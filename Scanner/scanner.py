# 对反编译后的Java代码和资源文件进行静态分析

import re
import os
import utils
import mysql
import base64
import constant


# 权限类
class Permission:
    dict = {
        'ACCEPT_HANDOVER': '允许呼叫应用继续在另一个应用中启动的呼叫, D',
        'ACCESS_CHECKIN_PROPERTIES': '允许对签入数据库中的“属性”表进行读 / 写访问，以更改上载的值, NU',
        'ACCESS_COARSE_LOCATION': '允许应用访问大致位置, D',
        'ACCESS_FINE_LOCATION': '允许应用访问精确位置, D',
        'ACCESS_LOCATION_EXTRA_COMMANDS': '允许应用程序访问额外的位置提供程序命令, N',
        'ACCESS_MOCK_LOCATION': '允许应用获取模拟定位，安装在用户手机中的应用不应该申请该权限, NU',
        'ACCESS_NETWORK_STATE': '允许应用程序访问有关网络的信息, N',
        'ACCESS_NOTIFICATION_POLICY': '对希望访问通知政策的应用程序的标记权限, N',
        'ACCESS_WIFI_STATE': '允许应用程序访问有关Wi - Fi网络的信息, N',
        'ACCOUNT_MANAGER': '允许应用程序调用AccountAuthenticators, NU',
        'ADD_VOICEMAIL': '允许应用程序将语音邮件添加到系统中, D',
        'ANSWER_PHONE_CALLS': '允许该应用接听来电, D',
        'BATTERY_STATS': '允许应用程序收集电池统计信息, N',
        'BIND_ACCESSIBILITY_SERVICE': '必须由AccessibilityService调用，以确保只有系统可以绑定它, S',
        'BIND_APPWIDGET': '允许应用程序告诉AppWidget服务哪个应用程序可以访问AppWidget的数据, NU',
        'BIND_AUTOFILL_SERVICE': '必须由a来要求AutofillService，以确保只有系统可以绑定它, S',
        'BIND_CARRIER_MESSAGING_SERVICE': '此常量在API级别23中已弃用。请改为BIND_CARRIER_SERVICES使用, S / P(O - 23)',
        'BIND_CARRIER_SERVICES': '允许绑定到运营商应用程序中的服务的系统进程将具有此权限, S / P',
        'BIND_CHOOSER_TARGET_SERVICE': '必须由ChooserTargetService调用，以确保只有系统可以绑定它, S',
        'BIND_CONDITION_PROVIDER_SERVICE': '必须由ConditionProviderService调用，以确保只有系统可以绑定它, S',
        'BIND_DEVICE_ADMIN': '必须由设备管理接收器要求，以确保只有系统可以与之交互, S',
        'BIND_DREAM_SERVICE': '必须由DreamService调用，以确保只有系统可以绑定它, S',
        'BIND_INCALL_SERVICE': '必须由InCallService调用，以确保只有系统可以绑定它, S / P',
        'BIND_INPUT_METHOD': '必须由InputMethodService调用，以确保只有系统可以绑定它, S',
        'BIND_MIDI_DEVICE_SERVICE': '必须由MidiDeviceService调用，以确保只有系统可以绑定它, S',
        'BIND_NFC_SERVICE': '必须由HostApduService或OffHostApduService调用，确保只有系统可以绑定它, S',
        'BIND_NOTIFICATION_LISTENER_SERVICE': '必须由NotificationListenerService调用，以确保只有系统可以绑定它, S',
        'BIND_PRINT_SERVICE': '必须由PrintService调用，以确保只有系统可以绑定它, S',
        'BIND_QUICK_SETTINGS_TILE': '允许应用程序绑定到第三方快速设置磁贴，只能由系统申请，并且附加TileService的声明, S / P',
        'BIND_REMOTEVIEWS': '必须由RemoteViewsService调用，以确保只有系统可以绑定它, S / P',
        'BIND_SCREENING_SERVICE': '必须由CallScreeningService调用，以确保只有系统可以绑定它, S / P',
        'BIND_TELECOM_CONNECTION_SERVICE': '必须由ConnectionService调用，以确保只有系统可以绑定它, S / P',
        'BIND_TEXT_SERVICE': '必须由TextService要求（例如, S',
        'BIND_TV_INPUT': '必须由TvInputService调用，确保只有系统可以绑定它, S / P',
        'BIND_VISUAL_VOICEMAIL_SERVICE': '必须通过链接VisualVoicemailService来确保只有系统可以绑定它, S / P',
        'BIND_VOICE_INTERACTION': '必须由VoiceInteractionService调用，以确保只有系统可以绑定它, S',
        'BIND_VPN_SERVICE': '必须由VpnService调用，以确保只有系统可以绑定它, S',
        'BIND_VR_LISTENER_SERVICE': '必须由VrListenerService调用，以确保只有系统可以绑定它, S',
        'BIND_WALLPAPER': '必须由WallpaperService调用，以确保只有系统可以绑定它, S / P',
        'BLUETOOTH': '允许应用程序连接到配对的蓝牙设备, N',
        'BLUETOOTH_ADMIN': '允许应用程序发现并配对蓝牙设备, N',
        'BLUETOOTH_PRIVILEGED': '允许应用程序在没有用户交互的情况下配对蓝牙设备，并允许或禁止电话簿访问或消息访问, NU',
        'BODY_SENSORS': '允许应用程序访问用户用来测量身体内部情况的传感器数据，例如心率, D',
        'BROADCAST_PACKAGE_REMOVED': '允许应用程序广播已删除应用程序包的通知, NU',
        'BROADCAST_SMS': '允许应用程序广播SMS收据通知, NU',
        'BROADCAST_STICKY': '允许应用程序广播粘性意图, N',
        'BROADCAST_WAP_PUSH': '允许应用程序广播WAP PUSH收据通知, NU',
        'CALL_PHONE': '允许应用程序在不通过拨号器用户界面的情况下发起电话呼叫，以便用户确认呼叫, D',
        'CALL_PRIVILEGED': '允许应用程序拨打任何电话号码（包括紧急号码），而无需通过拨号器用户界面以便用户确认正在拨打的电话, NU',
        'CAMERA': '需要能够访问相机设备, D',
        'CAPTURE_AUDIO_OUTPUT': '允许应用程序捕获音频输出, NU',
        'CAPTURE_SECURE_VIDEO_OUTPUT': '允许应用程序捕获安全视频输出, NU',
        'CAPTURE_VIDEO_OUTPUT': '允许应用程序捕获视频输出, NU',
        'CHANGE_COMPONENT_ENABLED_STATE': '允许应用程序更改是否启用了应用程序组件（除了它自己的组件）, NU',
        'CHANGE_CONFIGURATION': '允许应用程序修改当前配置，例如区域设置, N',
        'CHANGE_NETWORK_STATE': '允许应用程序更改网络连接状态, N',
        'CHANGE_WIFI_MULTICAST_STATE': '允许应用程序进入Wi - Fi多播模式, N',
        'CHANGE_WIFI_STATE': '允许应用程序更改Wi - Fi连接状态, N',
        'CLEAR_APP_CACHE': '允许应用程序清除设备上所有已安装应用程序的缓存, S / P',
        'CONTROL_LOCATION_UPDATES': '允许从收音机启用 / 禁用位置更新通知, NU',
        'DELETE_CACHE_FILES': '允许应用程序删除缓存文件，这是旧的权限，不再使用，但是我们可以简单地忽略它而不调用它，而不是抛出异常的信号, N',
        'DELETE_PACKAGES': '允许应用程序删除包, NU',
        'DIAGNOSTIC': '允许应用程序将RW转换为诊断资源, NU',
        'DISABLE_KEYGUARD': '允许应用程序在密钥保护不安全时禁用它, N',
        'DUMP': '允许应用程序从系统服务检索状态转储信息, NU',
        'EXPAND_STATUS_BAR': '允许应用程序展开或折叠状态栏, N',
        'FACTORY_TEST': '作为制造商测试应用程序运行，以root用户身份运行, NU',
        'FOREGROUND_SERVICE': '允许常规应用程序使用Service.startForeground, N',
        'GET_ACCOUNTS': '允许访问帐户服务中的帐户列表, D',
        'GET_ACCOUNTS_PRIVILEGED': '允许访问帐户服务中的帐户列表, N',
        'GET_PACKAGE_SIZE': '允许应用程序查找任何包使用的空间, N',
        'GET_TASKS': '此常量在API级别21中已弃用。不再强制执行, N / O - 21',
        'GLOBAL_SEARCH': '此权限可用于内容提供商，以允许全局搜索系统访问其数据, S / P',
        'INSTALL_LOCATION_PROVIDER': '允许应用程序将位置提供程序安装到位置管理器中, NU',
        'INSTALL_PACKAGES': '允许应用程序安装包, NU',
        'INSTALL_SHORTCUT': '允许应用程序在Launcher中安装快捷方式, N',
        'INSTANT_APP_FOREGROUND_SERVICE': '允许即时应用创建前台服务, N',
        'INTERNET': '允许应用程序打开网络套接字, N',
        'KILL_BACKGROUND_PROCESSES': '允许应用程序调用ActivityManager.killBackgroundProcesses(), N',
        'LOCATION_HARDWARE': '允许应用程序在硬件中使用位置功能，例如geofencing api, NU',
        'MANAGE_DOCUMENTS': '允许应用程序管理对文档的访问，通常作为文档选择器的一部分, S',
        'MANAGE_OWN_CALLS': '允许通过自我管理的ConnectionServiceAPI管理自己的调用的调用应用程序 , N',
        'MASTER_CLEAR': '不适用于第三方应用程序, NU',
        'MEDIA_CONTENT_CONTROL': '允许应用程序知道正在播放的内容并控制其播放, NU',
        'MODIFY_AUDIO_SETTINGS': '允许应用程序修改全局音频设置, N',
        'MODIFY_PHONE_STATE': '允许修改电话状态 - 开机，mmi等, NU',
        'MOUNT_FORMAT_FILESYSTEMS': '允许格式化可移动存储的文件系统, NU',
        'MOUNT_UNMOUNT_FILESYSTEMS': '允许安装和卸载文件系统以进行可移动存储, NU',
        'NFC': '允许应用程序通过NFC执行I / O操作, N',
        'NFC_TRANSACTION_EVENT': '允许应用程序接收NFC交易事件, N',
        'PACKAGE_USAGE_STATS': '允许应用程序收集组件使用情况统计信息，声明权限意味着使用API​​的意图，设备用户可以通过“设置”应用程序授予权限, D',
        'PERSISTENT_ACTIVITY': '此常量在API级别9中已弃用。此功能将在以后删除;请不要使用。允许应用程序使其活动持久, O - all',
        'PROCESS_OUTGOING_CALLS': '允许应用程序查看拨出呼叫期间拨打的号码，并选择将呼叫重定向到其他号码或完全中止呼叫, D',
        'READ_CALENDAR': '允许应用程序读取用户的日历数据, D',
        'READ_CALL_LOG': '允许应用程序读取用户的通话记录, D',
        'READ_CONTACTS': '允许应用程序读取用户的联系人数据, D',
        'READ_EXTERNAL_STORAGE': '允许应用程序从外部存储读取, D',
        'READ_FRAME_BUFFER': '允许应用程序进行屏幕截图，更一般地，可以访问帧缓冲区数据, NU',
        'READ_INPUT_STATE': '此常量在API级别16中已弃用。已删除使用此权限的API, NU / O - 16',
        'READ_LOGS': '允许应用程序读取低级系统日志文件, NU',
        'READ_PHONE_NUMBERS': '允许读取设备的电话号码, D',
        'READ_PHONE_STATE': '允许只读访问电话状态，包括设备的电话号码，当前的蜂窝网络信息，任何正在进行的呼叫的状态以及PhoneAccount在设备上注册的任何s的列表 , D',
        'READ_SMS': '允许应用程序读取SMS消息, D',
        'READ_SYNC_SETTINGS': '允许应用程序读取同步设置, N',
        'READ_SYNC_STATS': '允许应用程序读取同步统计信息, N',
        'READ_VOICEMAIL': '允许应用程序读取系统中的语音邮件, S / P',
        'REBOOT': '必须能够重启设备, NU',
        'RECEIVE_BOOT_COMPLETED': '允许应用程序接收Intent.ACTION_BOOT_COMPLETED系统完成引导后广播的应用程序 , N',
        'RECEIVE_MMS': '允许应用程序监控传入的MMS消息, D',
        'RECEIVE_SMS': '允许应用程序接收SMS消息, D',
        'RECEIVE_WAP_PUSH': '允许应用程序接收WAP推送消息, D',
        'RECORD_AUDIO': '允许应用程序录制音频, D',
        'REORDER_TASKS': '允许应用程序更改任务的Z - order, N',
        'REQUEST_COMPANION_RUN_IN_BACKGROUND': '允许随播应用在后台运行, N',
        'REQUEST_COMPANION_USE_DATA_IN_BACKGROUND': '允许配套应用在后台使用数据, N',
        'REQUEST_DELETE_PACKAGES': '允许应用程序请求删除包, N',
        'REQUEST_IGNORE_BATTERY_OPTIMIZATIONS': '必须持有申请才能使用Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, N',
        'REQUEST_INSTALL_PACKAGES': '允许应用程序请求安装包, S',
        'RESTART_PACKAGES': 'API级别8中不推荐使用此常量ActivityManager.restartPackage() 。不再支持API, O - all',
        'SEND_RESPOND_VIA_MESSAGE': '允许应用程序（电话）向其他应用程序发送请求，以处理来电期间的响应消息操作, NU',
        'SEND_SMS': '允许应用程序发送短信, D',
        'SET_ALARM': '允许应用程序广播Intent以为用户设置警报, N',
        'SET_ALWAYS_FINISH': '允许应用程序控制在后台放置活动是否立即完成, NU',
        'SET_ANIMATION_SCALE': '修改全局动画缩放系数, NU',
        'SET_DEBUG_APP': '配置应用程序以进行调试, NU',
        'SET_PREFERRED_APPLICATIONS': '此常量在API级别7中已弃用。不再有用，请参阅PackageManager.addPackageToPreferred()详细信息, O - all',
        'SET_PROCESS_LIMIT': '允许应用程序设置可以运行的最大（不需要）应用程序进程数, NU',
        'SET_TIME': '允许应用程序设置系统时间, NU',
        'SET_TIME_ZONE': '允许应用程序设置系统时区, NU',
        'SET_WALLPAPER': '允许应用程序设置壁纸, N',
        'SET_WALLPAPER_HINTS': '允许应用程序设置壁纸提示, N',
        'SIGNAL_PERSISTENT_PROCESSES': '允许应用程序请求将信号发送到所有持久进程, NU',
        'STATUS_BAR': '允许应用程序打开，关闭或禁用状态栏及其图标, NU',
        'SYSTEM_ALERT_WINDOW': '允许应用使用WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY所有其他应用上显示的类型创建窗口 , S',
        'TRANSMIT_IR': '允许使用设备的红外发射器（如果有）, N',
        'UNINSTALL_SHORTCUT': '请勿在您的应用中使用此权限, O - all',
        'UPDATE_DEVICE_STATS': '允许应用程序更新设备统计信息, NU',
        'USE_BIOMETRIC': '允许应用使用设备支持的生物识别模式, N',
        'USE_FINGERPRINT': '这个常量在API - 28已弃用，应用程序应申请权限USE_BIOMETRIC, N / O - 28',
        'USE_SIP': '允许应用程序使用SIP服务, D',
        'VIBRATE': '允许访问振动器, N',
        'WAKE_LOCK': '允许使用PowerManager WakeLocks防止处理器休眠或屏幕变暗, N',
        'WRITE_APN_SETTINGS': '允许应用程序编写apn设置, NU',
        'WRITE_CALENDAR': '允许应用程序写入用户的日历数据, D',
        'WRITE_CALL_LOG': '允许应用程序写入（但不读取）用户的呼叫日志数据, D',
        'WRITE_CONTACTS': '允许应用程序写入用户的联系人数据, D',
        'WRITE_EXTERNAL_STORAGE': '允许应用程序写入外部存储, D',
        'WRITE_GSERVICES': '许应用修改Google服务地图, NU',
        'WRITE_SECURE_SETTINGS': '允许应用程序读取或写入安全系统设置, NU',
        'WRITE_SETTINGS': '允许应用程序读取或写入系统设置, S',
        'WRITE_SYNC_SETTINGS': '允许应用程序写入同步设置, N',
        'WRITE_VOICEMAIL': '允许应用程序修改和删除系统中的现有语音邮件, S / P'
    }


# 正则表达式类
class Regex:
    # 01001.文件名提取
    file_name_pattern = re.compile(r'apk_sources/(.*?\.apk)')
    # 01004.包名检测
    package_pattern = re.compile(r'package="(.*?)"')
    # 01005.主活动检测
    main_activity_pattern = re.compile(r'activity.*?android:name=\"(.*?)\".*intent-filter.*MAIN', re.S)
    # 01006.最小SDK检测
    min_sdk_pattern = re.compile(r'minSdkVersion: \'(\d*)\'')
    # 01007.目标SDK检测
    target_sdk_pattern = re.compile(r'targetSdkVersion: \'(\d*)\'')
    # 02001.权限信息检测
    permission_pattern = re.compile(r'android\.permission\.(\w*)', re.M)
    # 03001 - 03004.四大组件检测
    activity_pattern = re.compile(r'<activity.*?android:name="(.*?)"', re.S)
    service_pattern = re.compile(r'<service.*?android:name="(.*?)"', re.S)
    receiver_pattern = re.compile(r'<receiver.*?android:name="(.*?)"', re.S)
    provider_pattern = re.compile(r'<provider.*?android:name="(.*?)"', re.S)
    # 04001.权限组检测
    permission_group_pattern = re.compile(r'(<permission.*?android:permissionGroup="(.*?)".*?>)', re.S)
    # 04002.系统权限使用检测，使用02001的正则匹配式
    # 04003.protectionLevel检测
    protection_level_pattern = re.compile(r'(<permission.*?android:protectionLevel="(.*?)".*?>)', re.S)
    # 04004.SharedUserId检测
    shared_user_id_pattern = re.compile(r'<manifest.*?android:sharedUserId="android.uid.system".*?>', re.S)
    # 04005.Allowbackup检测
    allowbackup_pattern = re.compile(r'<application.*android:allowBackup="true".*?>')
    # 04006.Debuggable检测
    debuggable_pattern = re.compile(r'<application.*android:debuggable="true".*?>')
    # 05001.Activity组件导出检测
    # 05002.Service组件导出检测
    # 05003.Receiver组件导出检测
    # 05004.Provider组件导出检测
    activity_component_pattern = re.compile(r'<activity(.*?)/>', re.S)
    service_component_pattern = re.compile(r'<service(.*?)/>', re.S)
    receiver_component_pattern = re.compile(r'<receiver(.*?)/>', re.S)
    provider_component_pattern = re.compile(r'<provider(.*?)/>', re.S)

    component_name_pattern = re.compile(r'android:name="(.*?)"', re.S)
    component_exported_pattern = re.compile(r'android:exported="(.*?)"', re.S)
    component_filter_pattern = re.compile(r'intent-filter', re.S)
    component_permission_pattern = re.compile(r'android:permission="(.*?)"', re.S)

    # 05005.Provider:grant-uri-permission属性检测
    provider_grant_uri_permission_pattern = re.compile(r'android:grantUriPermissions="true"', re.S)

    # 05006.Activity Intent-Based攻击检测
    activity_double_tag_pattern = re.compile(r'<activity.*?</activity>', re.S)
    activity_intent_browsable_pattern = re.compile(r'android.intent.category.BROWSABLE', re.S)

    # 05007.Intent Scheme URL漏洞攻击检测
    is_exist_intent_parseuri_pattern = re.compile(r'Intent +(\w+) *= *Intent\.parseUri', re.M)

    # 05008.应用本地拒绝服务漏洞检测
    new_intent_pattern = re.compile(r'Intent +(\w+) *= *new +Intent', re.M)
    get_intent_pattern = re.compile(r'Intent +(\w+) *= *getIntent', re.M)

    # 05010.Debug或Test敏感测试组件泄露检测
    debug_test_pattern = re.compile(r'debug|test', re.M | re.I)

    # 06001.WebView远程执行漏洞检测
    webview_addjs_pattern = re.compile(r'(\S+\.addJavascriptInterface.*);', re.M)
    webview_loadurl_pattern = re.compile(r'(\S+\.loadUrl.*);', re.M)

    # 06002.WebView潜在XSS攻击检测
    webview_setjs_pattern = re.compile(r'\S+\.setJavaScriptEnabled\(true\)', re.M)
    # 06003.WebView File域同源策略绕过漏洞检测
    webview_setfile_pattern = re.compile(r'\S+\.setAllowFileAccess\(true\)', re.M)
    # 06004.webview密码明文存储漏洞检测
    webview_setpw_pattern = re.compile(r'\S+\.setSavePassword\(true\)', re.M)

    # 06005.主机名弱校验漏洞检测
    hostname_pattern = re.compile(
        r'HostnameVerifier.*?new.*?boolean\s+verify\s*?\(String.*?SSLSession \w+\)\s*?{\s*?return true;\s*?}.*?}',
        re.S)

    # 06006.证书弱校验漏洞检测
    checkclient_pattern = re.compile(r'void checkClientTrusted', re.M)
    checkserver_pattern = re.compile(r'void checkServerTrusted', re.M)
    getissuers_pattern_A = re.compile(r'getAcceptedIssuers\(\)\s*?{\s*?return null;\s*?}', re.S)
    getissuers_pattern_B = re.compile(
        r'getAcceptedIssuers\(\)\s*?{\s*?return new X509Certificate\[0\];\s*?}',
        re.S)
    # 06007.中间人攻击漏洞检测
    allow_all_hostname_pattern = re.compile(r'(\S*ALLOW_ALL_HOSTNAME_VERIFIER\S*);', re.M)
    # 06008.WebView不校验证书漏洞检测
    webview_ignore_ssl_error_pattern = re.compile(r'new WebViewClient.*?onReceivedSslError.*?handler\.proceed', re.S)

    # 06009.WebView组件系统隐藏接口未移除漏洞
    webview_is_defined_pattern = re.compile(r'WebView (\w*)\b.*;', re.M)

    # 08001.SSL连接检测
    http_url_pattern = re.compile(r'"(http://.*?)"', re.M)

    # 08002.SSL不安全组件检测
    # SSLCertificateSocketFactory.getInsecure()是静态方法
    ssl_get_insecure_pattern = re.compile(r'^\s*(.*SSLCertificateSocketFactory\.getInsecure.*);', re.M)

    # 08003.HttpHost检测
    # java.lang.Object -> org.apache.hc.core5.http.HttpHost
    http_host_pattern = re.compile(r'^\s*(.*HttpHost.DEFAULT_SCHEME.*);', re.M)

    # 08005.网络端口开放威胁检测
    server_socket_pattern = re.compile(r'^\s*(.*ServerSocket\((\d*)\))', re.M)
    datagram_socket_pattern = re.compile(r'^\s*(.*DatagramSocket\((\d*)\))', re.M)

    # 09001.DES弱加密风险检测
    des_pattern = re.compile(r'^\s*(.*DES/\w{3}/.+Padding.*);', re.M)
    # 09002.不安全的密钥长度风险检测
    unsafe_key_pattern = re.compile(r'KeyPairGenerator\s+(\w+)\s*=\s*KeyPairGenerator\.getInstance.*;', re.M)
    # 09003.AES-ECB弱加密风险检测.
    aes_ecb_pattern = re.compile(r'^\s*(.*AES/ECB/.+Padding.*);', re.M)
    # 09004.IVParameterSpec不安全初始化向量检测
    iv_parameter_spec_pattern = re.compile(r'new\s+IvParameterSpec\((\w+)\)', re.M)
    # 09005.RSA中不使用Padding风险检测
    rsa_no_padding_pattern = re.compile(r'^\s*(.*RSA/\w+/NoPadding.*);', re.M)

    # 10001.敏感信息检测
    email_pattern = re.compile(r'[\w.-]+@[\w-]+\.[\w.]+', re.M)
    telephone_pattern = re.compile(r'((13\d|14[57]|15[0-3|5-8]|18[0-3|5-9])\d{8})', re.M)
    # 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    identity_code_pattern = re.compile(r'\d{15}|\d{17}[\dx]', re.M | re.I)
    # 10002.剪贴板敏感信息泄露风险检测
    clip_data_pattern = re.compile(r'\s*(.*ClipData\.newPlainText.*);', re.M)
    # 10003.Intent敏感数据泄露风险检测
    # intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent_setflag_pattern = re.compile(r'\s*(.*setFlags.*FLAG_ACTIVITY_NEW_TASK.*);', re.M)
    # 10004.PendingIntent误用风险
    pending_intent_pattern = re.compile(r'(PendingIntent\.get(Service|Activity|Broadcast)\(\w*, \w*, (\w*).*\))')
    # 10005.密钥硬编码
    # String str = "keyTest0755";
    # byte[] key = str.getBytes();
    # SecretKey secretKey = new SecretKeySpec(key, "AES");
    secretkeyspec_pattern = re.compile(r'new\s+SecretKeySpec\((\w+),.*\)')
    # 10007.BASE64安全检测
    base64_pattern = re.compile(r'"(([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==))"', re.M)
    # 10008.文件全局读写漏洞检测
    # MODE_WORLD_READABLE / MODE_WORLD_WRITEABLE -> MODE_PRIVATE
    # openFileOutput(String name, int mode)
    # getDir(String name, int mode)
    # getSharedPreferences(string name,int mode)
    openfile_output_pattern = re.compile(r'\s*(.*openFileOutput.*(MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE).*);', re.M)
    getdir_pattern = re.compile(r'\s*(.*getDir.*(MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE).*);', re.M)
    getsharedprefer_pattern = re.compile(
        r'\s*(.*getSharedPreferences.*(MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE).*);',
        re.M)
    # 10009.日志泄露风险检测
    # Log.v、Log.d、Log.e、Log.i、Log.w、Log.f、Log.s
    log_pattern = re.compile(r'\s*(Log\.[vdeiwfs].*);', re.M)
    # 11001.安全相关的函数检测
    safe_function_pattern = re.compile(
        r'(\w*(encrypt|decrypt|encod|decod|aes|sha1|sha256|sha512|md5|decode|encode)\w*\(.*?\))',
        re.M | re.I)
    # 11002.安全相关的类检测
    safe_class_pattern = re.compile(
        r'encrypt|decrypt|encod|decod|aes|sha1|sha256|sha512|md5|decode|encode',
        re.M | re.I)
    # 11003.运行命令检测
    getruntime_pattern = re.compile(r'Runtime\s+(\w+).*Runtime\.getRuntime\(\);', re.M)
    # 11004.Native Library加载检测
    load_library_pattern = re.compile(r'(System.loadLibrary\("\w+\.so"\));', re.M)
    # 11005.外部动态加载DEX检测
    # dexclassloader_pattern = re.compile(r'DexClassLoader.*=\s*?new\s+DexClassLoader\s*?\(.*?\);', re.S)
    dexclassloader_pattern = re.compile(r'\s*(.*=\s*?new\s+DexClassLoader\s*?\(.*?\));', re.M)
    # 11006.root代码检测
    root_exec_pattern = re.compile(r'\s*(.*\w+\.exec\s*\(\"su"\));', re.M)
    # 11007.获取IMEI和Device ID敏感信息代码检测
    getdeviceid_pattern = re.compile(r'\s*(.*getDeviceId.*);')
    # 11008.获取AndroidID敏感信息代码检测
    secure_androidid_pattern = re.compile(r'\s*(Secure\.getString.*Secure\.ANDROID_ID.*);', re.M)
    # 11009.发送SMS敏感代码检测
    send_sms_pattern = re.compile(r'\s*(.*send(Text|Data|Multimedia)Message\(.*\));', re.M)
    # 11010.文件删除代码检测
    getfile_pattern = re.compile(r'File\s+(\w+).*new\s+File.*;', re.M)
    # 11011.signature代码检测
    signature_pattern = re.compile(r'(\w+\s*=\s*\w+\.getPackageInfo.*?PackageManager\.GET_SIGNATURES\).*?);', re.S)
    # 12001.Fragment注入漏洞CVE-2013-6271检测
    isvalid_fragment_pattern = re.compile(
        r'extends PreferenceActivity.*boolean isValidFragment.*?{\s*return true;\s*?}',
        re.S)
    # 12003.随机数生成漏洞
    set_seed_pattern = re.compile(r'\s*(.*\.setSeed.+);', re.M)


def do_dynamic_scan(src_path, dst_path):
    # 连接数据库
    # file_name = '6dbb160cd0a97cd00f8837940728513fd0bc4b50f99721381091e478af51b563-1541469613-123.apk'
    db = mysql.connect_db()

    # 关闭数据库
    mysql.close_db(db)


def do_static_scan(src_path, dst_path):
    # 连接数据库
    # file_name = '6dbb160cd0a97cd00f8837940728513fd0bc4b50f99721381091e478af51b563-1541469613-123.apk'
    # file_name = '6dbb160cd0a97cd00f8837940728513fd0bc4b50f99721381091e478af51b563-1541469613-124.apk'
    db = mysql.connect_db()
    # 打开存储扫描结果的文件
    # res = open(dst_path + 'result', 'w')

    # 打开进行扫描的文件
    manifest_file = open(dst_path + 'apktool_unzip/AndroidManifest.xml', 'r')
    if manifest_file:
        manifest_content = manifest_file.read()
        manifest_file.close()
    else:
        # res.write('Find No Manifest File\n')
        return
    yml_file = open(dst_path + 'apktool_unzip/apktool.yml', 'r')
    if yml_file:
        yml_content = yml_file.read()
        yml_file.close()
    else:
        # res.write('Find No apktool.yml file')
        return

    # 01001.文件名
    file_name_obj = Regex.file_name_pattern.search(src_path)
    file_name = file_name_obj.group(1)
    # res.write('fileName:\n' + file_name + '\n\n')
    mysql.insert_into_db(db, file_name, '01001', file_name, -1, 1)

    # 01002.文件大小
    file_size = os.path.getsize(src_path)
    file_size /= float(1024 * 1024)
    file_size = round(file_size, 2)
    # res.write('fileSize:\n' + str(file_size) + 'MB\n\n')
    mysql.insert_into_db(db, file_name, '01002', str(file_size) + 'MB', -1, 1)

    # 01003.文件的MD5值
    file_md5 = utils.get_file_md5(src_path)
    # res.write('fileMd5:\n' + file_md5 + '\n\n')
    mysql.insert_into_db(db, file_name, '01003', file_md5, -1, 1)

    # 01004.包名扫描
    package_obj = Regex.package_pattern.search(manifest_content)
    if package_obj:
        package_str = package_obj.group(1)
        # res.write('package:\n' + package_str + '\n\n')
        mysql.insert_into_db(db, file_name, '01004', package_str, -1, 1)
    else:
        # res.write('package:\nNo find\n\n')
        pass

    # 01005.主活动扫描
    main_activity_obj = Regex.main_activity_pattern.search(manifest_content)
    if main_activity_obj:
        main_activity_str = main_activity_obj.group(1)
        # res.write('mainActivity:\n' + main_activity_str + '\n\n')
        mysql.insert_into_db(db, file_name, '01005', main_activity_str, -1, 1)
    else:
        # res.write('mainActivity:\nNo find\n\n')
        pass

    # 01006.最小SDK扫描
    min_sdk_obj = Regex.min_sdk_pattern.search(yml_content)
    if min_sdk_obj:
        min_sdk_str = min_sdk_obj.group(1)
        # res.write('minSdkVersion:\n' + min_sdk_str + '\n\n')
        mysql.insert_into_db(db, file_name, '01006', min_sdk_str, -1, 1)
    else:
        # res.write('minSdkVersion:\nNo find\n\n')
        pass

    # 01007.目标SDK扫描
    target_sdk_obj = Regex.target_sdk_pattern.search(yml_content)
    if target_sdk_obj:
        target_sdk_str = target_sdk_obj.group(1)
        # res.write('targetSdkVersion:\n' + target_sdk_str + '\n\n')
        mysql.insert_into_db(db, file_name, '01007', target_sdk_str, -1, 1)
    else:
        # res.write('targetSdkVersion:\nNo find\n\n')
        pass

    # 02001.权限扫描
    permission_obj = Regex.permission_pattern.findall(manifest_content)
    permission_list = []
    if permission_obj:
        for i in range(0, permission_obj.__len__(), 1):
            tmp = permission_obj[i]
            if tmp in Permission.dict.keys():

                list_src = Permission.dict[tmp].split(',')
                list_dst = '</td><td>'.join(list_src)
                # 根据权限的等级来选择HTML的显示样式
                lev = list_src[1]
                if lev == ' D' or lev == ' S' or lev == ' S/P' or lev == ' NU':
                    permission_list.append('<tr class="info"><td>' + str(i) + '</td><td>' + tmp + '</td><td>'
                                           + list_dst + '</td></tr>')
                else:
                    permission_list.append('<tr><td>' + str(i) + '</td><td>' + tmp + '</td><td>'
                                           + list_dst + '</td></tr>')
            else:
                permission_list.append(tmp + ', NONE')
        permission_str = '\n'.join(permission_list)
        # res.write('permission:\n' + permission_str + '\n\n')
        mysql.insert_into_db(db, file_name, '02001', permission_str, -1, 1)
    else:
        # res.write('permission:\nNo Find\n\n')
        pass

    # 03001 - 03004.四大组件扫描
    activity_obj = Regex.activity_pattern.findall(manifest_content)
    service_obj = Regex.service_pattern.findall(manifest_content)
    receiver_obj = Regex.receiver_pattern.findall(manifest_content)
    provider_obj = Regex.provider_pattern.findall(manifest_content)
    component_obj = activity_obj + service_obj + receiver_obj + provider_obj
    if activity_obj:
        activity_str = '\n'.join(activity_obj)
        # res.write('activity:\n' + activity_str + '\n\n')
        mysql.insert_into_db(db, file_name, '03001', activity_str, -1, len(activity_obj))
    else:
        # res.write('activity:\nNo find\n\n')
        pass
    if service_obj:
        service_str = '\n'.join(service_obj)
        # res.write('service:\n' + service_str + '\n\n')
        mysql.insert_into_db(db, file_name, '03002', service_str, -1, len(service_obj))
    else:
        # res.write('service:\nNo find\n\n')
        pass
    if receiver_obj:
        receiver_str = '\n'.join(receiver_obj)
        # res.write('receiver:\n' + receiver_str + '\n\n')
        mysql.insert_into_db(db, file_name, '03003', receiver_str, -1, len(receiver_obj))
    else:
        # res.write('receiver:\nNo find\n\n')
        pass
    if provider_obj:
        provider_str = '\n'.join(provider_obj)
        # res.write('provider:\n' + provider_str + '\n\n')
        mysql.insert_into_db(db, file_name, '03004', provider_str, -1, len(provider_obj))
    else:
        # res.write('provider:\nNo find\n\n')
        pass

    # 04001.权限组检测
    permission_group_obj = Regex.permission_group_pattern.findall(manifest_content)
    permission_group_list = []
    res_04001 = []
    num_04001 = 0
    # res.write('permissionGroup:\n')
    flag = 0

    if permission_group_obj:
        for i in range(0, len(permission_group_obj), 1):
            if permission_group_obj[i][1] == '':
                permission_group_list.append(permission_group_obj[i][0])
                flag = 1

        if flag == 0:
            # res.write('Safe\n\n')
            # mysql.insert_into_db(db, file_name, '04001', '安全', -1, 0)
            pass
        else:
            # permission_str = '\n'.join(permission_group_list)
            # res.write(permission_str + '\n\n')
            # mysql.insert_into_db(db, file_name, '04001', permission_str, 0, len(permission_group_list))
            res_04001 = permission_group_list
            num_04001 = len(permission_group_list)
    else:
        # res.write('No find\n\n')
        # mysql.insert_into_db(db, file_name, '04001', '未发现符合的匹配项', -1, 0)
        pass

    # 04002.系统权限检测
    system_per_list = []
    res_04002 = []
    num_04002 = 0
    if permission_obj:
        for i in range(0, len(permission_obj), 1):
            per = permission_obj[i]
            system_per = [
                'WRITE_SECURE_SETTINGS',
                'INSTALL_PACKAGES,'
                'MOUNT_FORMAT_FILESYSTEMS',
                'MOUNT_UNMOUNT_FILESYSTEMS',
                'RESTART_PACKAGES'
            ]
            if per in system_per:
                system_per_list.append('<uses-permission android.name="android.' + per + '">')
        # system_per_str = '\n'.join(system_per_list)
        if len(system_per_list) == 0:
            # res.write('system_permission:\n' + '未发现目标权限' + '\n\n')
            # mysql.insert_into_db(db, file_name, '04002', '安全', -1, 0)
            pass
        else:
            # res.write('system_permission:\n' + system_per_str + '\n\n')
            # mysql.insert_into_db(db, file_name, '04002', system_per_str, 0, len(system_per_list))
            res_04002 = system_per_list
            num_04002 = len(system_per_list)

    else:
        # res.write('system_permission:\n应用未申请任何权限\n\n')
        # mysql.insert_into_db(db, file_name, '04002', '安全', -1, 0)
        pass

    # 04003.权限的protectionLevel检测
    protection_level_obj = Regex.protection_level_pattern.findall(manifest_content)
    protection_level_list = []
    res_04003 = []
    num_04003 = 0
    # res.write('protectionLevel:\n')
    flag = 0
    if protection_level_obj:
        for i in range(0, len(protection_level_obj), 1):
            temp = protection_level_obj[i][1]
            if temp == '' or temp == 'normal' or temp == 'dangerous':
                flag = 1
                protection_level_list.append(protection_level_obj[i][0])
        if flag == 0:
            # res.write('Safe\n\n')
            mysql.insert_into_db(db, file_name, '04003', '安全', -1, 0)
        else:
            # res.write(protection_level_str + '\n\n')
            res_04003 = protection_level_list
            num_04003 = len(protection_level_list)
    else:
        # res.write('No find\n\n')
        pass

    # 04004.SharedUserId检测
    shared_user_id_obj = Regex.shared_user_id_pattern.search(manifest_content)
    res_04004 = []
    num_04004 = 0
    level_04004 = -1
    if shared_user_id_obj and int(min_sdk_str) <= 19:
        # res.write('SharedUserId检测:\n' + shared_user_id_obj.group(0) + '\nmin_sdk <= 19高危\n\n')
        res_04004.append(shared_user_id_obj.group(0))
        num_04004 = 1
        level_04004 = 3
    elif int(min_sdk_str) > 19:
        # res.write('SharedUserId检测:\n' + shared_user_id_obj.group(0) + '\nmin_sdk > 19提醒\n\n')
        res_04004.append(shared_user_id_obj.group(0))
        num_04004 = 1
        level_04004 = 0
    else:
        # res.write('SharedUserId检测:\n安全')
        pass

    # 04005.Allow Backup选项扫描
    allowbackup_obj = Regex.allowbackup_pattern.search(manifest_content)
    res_04005 = []
    num_04005 = 0
    if allowbackup_obj:
        # res.write('allowbackup:\n')
        allowbackup_str = allowbackup_obj.group(0)
        # res.write(allowbackup_str + '\n\n')
        res_04005.append(allowbackup_str)
        num_04005 = 1
    else:
        # res.write('allowbackup:\nSafe\n\n')
        pass

    # 04006.Debuggable选项扫描
    debuggable_obj = Regex.debuggable_pattern.search(manifest_content)
    res_04006 = []
    num_04006 = 0
    if debuggable_obj:
        debuggable_str = debuggable_obj.group(0)
        # res.write(debuggable_str + '\n\n')
        res_04006.append(debuggable_str)
        num_04006 = 1
    else:
        # res.write('debuggable:\nSafe\n\n')
        pass

    # 04007.非必要权限检测
    unnecessary_per_list = []
    res_04007 = []
    num_04007 = 0
    if permission_obj:
        for i in range(0, len(permission_obj), 1):
            per = permission_obj[i]
            unnecessary_per = [
                'ACCESS_MOCK_LOCATION'
            ]
            if per in unnecessary_per:
                unnecessary_per_list.append('<uses-permission android.name="android.' + per + '">')
        if len(unnecessary_per_list) == 0:
            # res.write('unnecessary_permission:\n' + '未发现目标权限' + '\n\n')
            pass
        else:
            # res.write('unnecessary_permission:\n' + unnecessary_per_str + '\n\n')
            res_04007 = unnecessary_per_list
            num_04007 = len(unnecessary_per_list)
    else:
        # res.write('unnecessary_permission:\n该应用未申请任何权限\n\n')
        pass

    # 04008.APP最低版本检测
    min_sdk_info_dict = {
        '16': '2012年6月 BuildVersionCodes.JellyBean',
        '15': '2013年2月 BuildVersionCodes'
    }
    min_sdk_leak_num_dic = {
        '16': 5,
        '15': 7
    }
    min_sdk_info = '您的应用所支持的最小的版本是' + min_sdk_str + '\n'
    res_04008 = [min_sdk_info + min_sdk_info_dict[min_sdk_str]]
    num_04008 = min_sdk_leak_num_dic[min_sdk_str]

    # 05001.Activity组件导出检测
    activity_component_obj = Regex.activity_component_pattern.findall(manifest_content)
    result_a = component_exported_search('activity', activity_component_obj)
    res_05001 = result_a['exported_list']
    num_05001 = result_a['num']

    # 05002.Service组件导出检测
    service_component_obj = Regex.service_component_pattern.findall(manifest_content)
    result_s = component_exported_search('service', service_component_obj)
    res_05002 = result_s['exported_list']
    num_05002 = result_s['num']

    # 05003.Receiver组件导出检测
    receiver_component_obj = Regex.receiver_component_pattern.findall(manifest_content)
    result_r = component_exported_search('receiver', receiver_component_obj)
    res_05003 = result_r['exported_list']
    num_05003 = result_r['num']

    # 05004.Provider组件导出检测
    provider_component_obj = Regex.provider_component_pattern.findall(manifest_content)
    result_p = component_exported_search('provider', provider_component_obj)
    res_05004 = result_p['exported_list']
    num_05004 = result_p['num']
    result_component_exported_true = \
        result_a['exported_list'] + \
        result_s['exported_list'] + \
        result_r['exported_list'] + \
        result_p['exported_list']

    # 05005.Provider:grant-uri-permission属性检测
    result = provider_grant_uri_permission_search(provider_component_obj)
    res_05005 = result['res_list']
    num_05005 = result['num']

    # 05006.Activity Intent-Based攻击检测
    activity_double_tag_obj = Regex.activity_double_tag_pattern.findall(manifest_content)
    result = activity_intent_browsable_search(activity_double_tag_obj)
    res_05006 = result['res_list']
    num_05006 = result['num']

    # 存储进入数据库
    save(db, file_name, '04001', res_04001, 0, num_04001)
    save(db, file_name, '04002', res_04002, 0, num_04002)
    save(db, file_name, '04003', res_04003, 0, num_04003)
    save(db, file_name, '04004', res_04004, level_04004, num_04004)
    save(db, file_name, '04005', res_05005, 1, num_04005)
    save(db, file_name, '04006', res_04006, 3, num_04006)
    save(db, file_name, '04007', res_04007, 0, num_04007)
    save(db, file_name, '04008', res_04008, -2, num_04008)
    save(db, file_name, '05001', res_05001, 2, num_05001)
    save(db, file_name, '05002', res_05002, 2, num_05002)
    save(db, file_name, '05003', res_05003, 2, num_05003)
    save(db, file_name, '05004', res_05004, 3, num_05004)
    save(db, file_name, '05005', res_05005, 0, num_05005)
    save(db, file_name, '05006', res_05006, 1, num_05006)
    save(db, file_name, '05005', res_05005, 0, num_05005)
    save(db, file_name, '05006', res_05006, 1, num_05006)

    # 计数变量和结果变量
    num_05007 = 0
    num_05008 = 0
    num_05009 = 0
    num_05010 = 0
    num_05011 = 0
    res_05007 = []
    res_05008 = []
    res_05009 = []
    res_05010 = []
    res_05011 = []

    num_06001 = 0
    num_06002 = 0
    num_06003 = 0
    num_06004 = 0
    num_06005 = 0
    num_06006 = 0
    num_06007 = 0
    num_06008 = 0
    num_06009 = 0
    res_06001 = []
    res_06002 = []
    res_06003 = []
    res_06004 = []
    res_06005 = []
    res_06006 = []
    res_06007 = []
    res_06008 = []
    res_06009 = []

    num_08001 = 0
    num_08002 = 0
    num_08003 = 0
    num_08005 = 0
    res_08001 = []
    res_08002 = []
    res_08003 = []
    res_08005 = []

    num_07001 = 0
    num_07002 = 0
    res_07001 = []
    res_07002 = []

    num_09001 = 0
    num_09002 = 0
    num_09003 = 0
    num_09004 = 0
    num_09005 = 0
    res_09001 = []
    res_09002 = []
    res_09003 = []
    res_09004 = []
    res_09005 = []

    num_10001 = 0
    num_10002 = 0
    num_10003 = 0
    num_10004 = 0
    num_10005 = 0
    num_10007 = 0
    num_10008 = 0
    num_10009 = 0
    res_10001 = []
    res_10002 = []
    res_10003 = []
    res_10004 = []
    res_10005 = []
    res_10007 = []
    res_10008 = []
    res_10009 = []

    num_11001 = 0
    num_11002 = 0
    num_11003 = 0
    num_11004 = 0
    num_11005 = 0
    num_11006 = 0
    num_11007 = 0
    num_11008 = 0
    num_11009 = 0
    num_11010 = 0
    num_11011 = 0
    res_11001 = []
    res_11002 = []
    res_11003 = []
    res_11004 = []
    res_11005 = []
    res_11006 = []
    res_11007 = []
    res_11008 = []
    res_11009 = []
    res_11010 = []
    res_11011 = []

    num_12001 = 0
    num_12002 = 0
    num_12003 = 0
    res_12001 = []
    res_12002 = []
    res_12003 = []

    # 需要遍历java文件的扫描项
    outcome_java_dir = dst_path + 'procyon_decompile_java/'
    source_component_list = []
    for parent, java_dir_names, java_file_names in os.walk(outcome_java_dir):
        for java_file_name in java_file_names:
            print('Analysing %s ' % java_file_name)

            def comment_replace(matched):
                return str(matched.group(1))  # 强制类型转换，以防出错

            java_file_path = os.path.join(parent, java_file_name)
            show_java_file_path = re.sub(r'.*procyon_decompile_java/', '', java_file_path, 0, re.M)
            tran_java_file_path = re.sub(r'/', '.', show_java_file_path, 0, re.M)
            tran_java_file_path = re.sub(r'\.java$', '', tran_java_file_path, 1, re.M)
            print('Full -> (%s)' % tran_java_file_path)
            source_component_list.append(tran_java_file_path)

            # ONLY_IN_PACKAGE标志位控制扫描是否限于包目录
            if constant.ONLY_IN_PACKAGE == 1 and (package_str not in tran_java_file_path):
                continue  # 使用continue结束本次循环，使用break是错误的

            java_file = open(java_file_path)
            java_content = java_file.read()
            java_file.close()
            # 消除代码间的行注释，需要考虑到
            # 行尾符号$不包括\n
            java_content = re.sub(r'([;{}] *)//.*$', comment_replace, java_content, 0, re.M)
            # 消除行首就是//的注释
            java_content = re.sub(r'^[\t ]*//.*\n', '', java_content, 0, re.M)
            # 消除调使用/**/包裹的块注释
            java_content = re.sub(r'/\*.*?\*/', '', java_content, 0, re.S)

            # 05007.Intent Scheme URL漏洞攻击检测
            intent_parseuri_obj = Regex.is_exist_intent_parseuri_pattern.findall(java_content)
            for intent_obj in intent_parseuri_obj:
                flag_1 = re.search(r'%s\.addCategory\("android\.intent\.category\.BROWSABLE"\)' % intent_obj,
                                   java_content, re.M)
                flag_2 = re.search(r'%s\.setComponent\(null\)' % intent_obj, java_content, re.M)
                flag_3 = re.search(r'%s\.setSelector\(null\)' % intent_obj, java_content, re.M)
                if flag_1 and flag_2 and flag_3:
                    # print('05007 # %s: %s.parseUri()安全' % (show_java_file_path, intent_obj))
                    pass
                else:
                    # print('05007 # %s: %s.parseUri()不安全' % (show_java_file_path, intent_obj))
                    cell = '05007 # %s: %s.parseUri()不安全' % (show_java_file_path, intent_obj)
                    res_05007.append(cell)
                    num_05007 = num_05007 + 1

            # 05008.应用本地拒绝服务漏洞检测
            new_intent_obj = Regex.new_intent_pattern.findall(java_content)
            for intent_obj in new_intent_obj:
                # 这个正则匹配式比较复杂，使用了前向否定符
                try_catch_matched_obj = re.search(r'try *{((?!Exception).)*?%s\.getAction.*?} *catch Exception *{.*?}' %
                                                  intent_obj, java_content, re.S)
                is_call_get_action_obj = re.search(r'%s\.getAction' % intent_obj, java_content, re.M)
                if is_call_get_action_obj and try_catch_matched_obj:
                    pass
                    # print('05008 # %s: %s.getAction()安全 - 有使用try-catch捕获异常' % (show_java_file_path, intent_obj))
                elif is_call_get_action_obj and not try_catch_matched_obj:
                    # print('05008 # %s: %s.getAction()不安全 - 未进行异常处理' % (show_java_file_path, intent_obj))
                    cell = '05008 # %s: %s.getAction()不安全 - 未进行异常处理' % (show_java_file_path, intent_obj)
                    res_05008.append(cell)
                    num_05008 = num_05008 + 1
                else:
                    pass
                    # print('05008 # %s: %s.getAction()安全 - 未调用getAction方法' % (show_java_file_path, intent_obj))

            get_intent_obj = Regex.get_intent_pattern.findall(java_content)
            # print(get_intent_obj)
            for intent_obj in get_intent_obj:
                get_extra_obj = re.findall(r'%s\.(get\w*?Extra)\((.*?)\)' % intent_obj, java_content, re.M)
                # print(intent_obj)
                for extra_obj in get_extra_obj:
                    try_catch_matched_obj = re.search(
                        r'try *{((?!Exception).)*?%s\.%s\(%s\).*?} *catch Exception *{.*?}' %
                        (intent_obj, extra_obj[0], extra_obj[1]), java_content, re.S)
                    if try_catch_matched_obj:
                        pass
                        # print('05008 # %s: %s.%s(%s)安全 - 有使用try-catch捕获异常' % (
                        #     show_java_file_path, intent_obj,
                        #     extra_obj[0],
                        #     extra_obj[1])
                        # )
                    else:
                        # print('05008 # %s: %s.%s(%s)不安全 - 未进行异常处理' % (
                        #     show_java_file_path, intent_obj,
                        #     extra_obj[0],
                        #     extra_obj[1])
                        # )
                        cell = '05008 # %s: %s.%s(%s)不安全 - 未进行异常处理' % (
                            show_java_file_path, intent_obj,
                            extra_obj[0],
                            extra_obj[1])
                        res_05008.append(cell)
                        num_05008 = num_05008 + 1


            # 05011.Intent不安全反射风险检测
            flag_1 = re.search(r'getIntent', java_content, re.M)
            flag_2 = re.search(r'Class\.forName', java_content, re.M)

            if flag_1 and flag_2 and (tran_java_file_path in result_component_exported_true):
                # print('05011 # %s: 存在Intent不安全反射的风险' % show_java_file_path)
                cell = '05011 # %s: 存在Intent不安全反射的风险' % show_java_file_path
                res_05011.append(cell)
                num_05011 = num_05011 + 1

            # 06001.WebView远程执行漏洞检测
            webview_addjs_obj = Regex.webview_addjs_pattern.findall(java_content)
            for scan_res in webview_addjs_obj:
                # print('06001 # %s: %s不安全' % (show_java_file_path, scan_res))
                cell = '06001 # %s: %s不安全' % (show_java_file_path, scan_res)
                res_06001.append(cell)
                num_06001 = num_06001 + 1
            webview_loadurl_obj = Regex.webview_loadurl_pattern.findall(java_content)
            for scan_res in webview_loadurl_obj:
                # print('06001 # %s: %s不安全' % (show_java_file_path, scan_res))
                cell = '06001 # %s: %s不安全' % (show_java_file_path, scan_res)
                res_06001.append(cell)
                num_06001 = num_06001 + 1

            # 06002.WebView潜在XSS攻击检测
            webview_setjs_obj = Regex.webview_setjs_pattern.findall(java_content)
            for scan_res in webview_setjs_obj:
                # print('06002 # %s: %s不安全' % (show_java_file_path, scan_res))
                cell = '06002 # %s: %s不安全' % (show_java_file_path, scan_res)
                res_06002.append(cell)
                num_06002 = num_06002 + 1

            # 06003.WebView File域同源策略绕过漏洞检测
            webview_setfile_obj = Regex.webview_setfile_pattern.findall(java_content)
            for scan_res in webview_setfile_obj:
                if tran_java_file_path in result_component_exported_true:  # 还需要判断是否能导出
                    # print('06003 # %s: %s不安全 - true且所在的该组件能导出' % (show_java_file_path, scan_res))
                    cell = '06003 # %s: %s不安全 - true且所在的该组件能导出' % (show_java_file_path, scan_res)
                    res_06003.append(cell)
                    num_06003 = num_06003 + 1
                else:
                    pass

            # 06004.webview密码明文存储漏洞检测
            webview_setpw_obj = Regex.webview_setpw_pattern.findall(java_content)
            for scan_res in webview_setpw_obj:
                # print('06004 # %s: %s不安全' % (show_java_file_path, scan_res))
                cell = '06004 # %s: %s不安全' % (show_java_file_path, scan_res)
                res_06004.append(cell)
                num_06004 = num_06004 + 1

            # 06005.主机名弱校验漏洞检测
            hostname_obj = Regex.hostname_pattern.findall(java_content)
            for scan_res in hostname_obj:
                # print('06005 # %s: %s不安全 - 未真正实现verify()方法' % (show_java_file_path, scan_res))
                cell = '06005 # %s: %s不安全 - 未真正实现verify()方法' % (show_java_file_path, scan_res)
                res_06005.append(cell)
                num_06005 = num_06005 + 1

            # 06006.证书弱校验漏洞检测
            checkclient_obj = Regex.checkclient_pattern.findall(java_content)
            for scan_res in checkclient_obj:
                # print('06006 # %s: %s()不安全 - 接受任意客户端证书' % (show_java_file_path, scan_res))
                cell = '06006 # %s: %s()不安全 - 接受任意客户端证书' % (show_java_file_path, scan_res)
                res_06006.append(cell)
                num_06006 = num_06006 + 1
            checkserver_obj = Regex.checkserver_pattern.findall(java_content)
            for scan_res in checkserver_obj:
                # print('06006 # %s: %s()不安全 - 接受任意服务端证书' % (show_java_file_path, scan_res))
                cell = '06006 # %s: %s()不安全 - 接受任意客户端证书' % (show_java_file_path, scan_res)
                res_06006.append(cell)
                num_06006 = num_06006 + 1

            getissuers_A_obj = Regex.getissuers_pattern_A.findall(java_content)
            for scan_res in getissuers_A_obj:
                # print('06006 # %s: %s不安全 - return null' % (show_java_file_path, scan_res))
                cell = '06006 # %s: %s不安全 - return null' % (show_java_file_path, scan_res)
                res_06006.append(cell)
                num_06006 = num_06006 + 1
            getissuers_B_obj = Regex.getissuers_pattern_B.findall(java_content)
            for scan_res in getissuers_B_obj:
                # print('06006 # %s: %s不安全 - return new X509Certificate[0]' % (show_java_file_path, scan_res))
                cell = '06006 # %s: %s不安全 - return new X509Certificate[0]' % (show_java_file_path, scan_res)
                res_06006.append(cell)
                num_06006 = num_06006 + 1

            # 06007.中间人攻击漏洞检测
            allow_all_hostname_obj = Regex.allow_all_hostname_pattern.findall(java_content)
            for scan_res in allow_all_hostname_obj:
                # print('06007 # %s: %s不安全 - 关闭host验证，信任所有主机名' % (show_java_file_path, scan_res))
                cell = '06007 # %s: %s不安全 - 关闭host验证，信任所有主机名' % (show_java_file_path, scan_res)
                res_06007.append(cell)
                num_06007 = num_06007 + 1

            # 06008.WebView不校验证书漏洞检测
            webview_ignore_ssl_error_obj = Regex.webview_ignore_ssl_error_pattern.findall(java_content)
            for scan_res in webview_ignore_ssl_error_obj:
                # print('06008 # %s: %s不安全 - 使用了handler.proceed()来忽略证书错误' % (show_java_file_path, scan_res))
                cell = '06008 # %s: %s不安全 - 使用了handler.proceed()来忽略证书错误' % (show_java_file_path, scan_res)
                res_06008.append(cell)
                num_06008 = num_06008 + 1

            # 06009.WebView组件系统隐藏接口未移除漏洞
            webview_is_defined = Regex.webview_is_defined_pattern.findall(java_content)
            for webview_instance in webview_is_defined:
                webview_searchbox_is_removed = re.search(
                    r'%s\.removeJavascriptInterface\("searchBoxJavaBridge_"\)' % webview_instance,
                    java_content,
                    re.M)
                webview_accesstravel_is_removed = re.search(
                    r'%s\.removeJavascriptInterface\("accessibilityTraversal"\)' % webview_instance,
                    java_content,
                    re.M)
                webview_access_is_removed = re.search(
                    r'%s\.removeJavascriptInterface\("accessibility"\)' % webview_instance,
                    java_content,
                    re.M)
                if not webview_searchbox_is_removed:
                    # print('06009 # %s: %s未显示地移除searchBoxJavaBridge_接口' % (show_java_file_path, webview_instance))
                    cell = '06009 # %s: %s未显示地移除searchBoxJavaBridge_接口' % (show_java_file_path, webview_instance)
                    res_06009.append(cell)
                    num_06009 = num_06009 + 1
                if not webview_accesstravel_is_removed:
                    # print('06009 # %s: %s未显示地移除accessibilityTraversal接口' % (show_java_file_path, webview_instance))
                    cell = '06009 # %s: %s未显示地移除accessibilityTraversal接口' % (show_java_file_path, webview_instance)
                    res_06009.append(cell)
                    num_06009 = num_06009 + 1
                if not webview_access_is_removed:
                    # print('06009 # %s: %s未显示地移除accessibility接口' % (show_java_file_path, webview_instance))
                    cell = '06009 # %s: %s未显示地移除accessibility接口' % (show_java_file_path, webview_instance)
                    res_06009.append(cell)
                    num_06009 = num_06009 + 1

            # 08001.SSL连接检测
            http_url_obj = Regex.http_url_pattern.findall(java_content)
            for scan_res in http_url_obj:
                # print('08001 # %s: %s - 未使用https协议加载url' % (show_java_file_path, scan_res))
                # if package_str in tran_java_file_path:
                cell = '08001 # %s: %s - 未使用https协议加载url' % (show_java_file_path, scan_res)
                res_08001.append(cell)
                num_08001 = num_08001 + 1

            # 08002.SSL不安全组件检测
            # SSLCertificateSocketFactory.getInsecure()是静态方法
            ssl_get_insecure_obj = Regex.ssl_get_insecure_pattern.findall(java_content)
            for scan_res in ssl_get_insecure_obj:
                # print('08002 # %s: %s' % (show_java_file_path, scan_res))
                cell = '08002 # %s: %s' % (show_java_file_path, scan_res)
                res_08002.append(cell)
                num_08002 = num_08002 + 1

            # 08003.HttpHost检测
            # java.lang.Object -> org.apache.hc.core5.http.HttpHost
            http_host_obj = Regex.http_host_pattern.findall(java_content)
            for scan_res in http_host_obj:
                # print('08003 # %s: %s不安全 - DEFAULT_SCHEME默认使用HTTP' % (show_java_file_path, scan_res))
                cell = '08003 # %s: %s不安全 - DEFAULT_SCHEME默认使用HTTP' % (show_java_file_path, scan_res)
                res_08003.append(cell)
                num_08003 = num_08003 + 1

            # 08005.网络端口开放威胁检测
            server_socket_obj = Regex.server_socket_pattern.findall(java_content)
            for scan_res in server_socket_obj:
                # print('08005 # %s: %s不安全 - %s端口开放(TCP)' % (show_java_file_path, scan_res[0], scan_res[1]))
                cell = '08005 # %s: %s不安全 - %s端口开放(TCP)' % (show_java_file_path, scan_res[0], scan_res[1])
                res_08005.append(cell)
                num_08005 = num_08005 + 1
            datagram_socket_obj = Regex.datagram_socket_pattern.findall(java_content)
            for scan_res in datagram_socket_obj:
                # print('08005 # %s: %s不安全 - %s端口开放(UDP)' % (show_java_file_path, scan_res[0], scan_res[1]))
                cell = '08005 # %s: %s不安全 - %s端口开放(UDP)' % (show_java_file_path, scan_res[0], scan_res[1])
                res_08005.append(cell)
                num_08005 = num_08005 + 1

            # 09001.DES弱加密风险检测
            # des_pattern = re.compile(r'^\s*(.*DES/(\w){3}/.+Padding.*);', re.M)
            des_obj = Regex.des_pattern.findall(java_content)
            for scan_res in des_obj:
                # print('09001 # %s: %s' % (show_java_file_path, scan_res))
                cell = '09001 # %s: %s' % (show_java_file_path, scan_res)
                res_09001.append(cell)
                num_09001 = num_09001 + 1
            # 09002.不安全的密钥长度风险检测
            # unsafe_key_pattern = re.compile(r'KeyPairGenerator\s+(\w+)\s*=KeyPairGenerator.getInstance.*;')
            keygens = Regex.unsafe_key_pattern.findall(java_content)
            for keygen in keygens:
                keylen = re.search(r'%s\.initialize\((\d+)\)' % keygen, java_content, re.M)
                if int(keylen.group(1)) <= 512:
                    # print('09002 # %s: %s' % (show_java_file_path, keylen.group(0)))
                    cell = '09002 # %s: %s' % (show_java_file_path, keylen.group(0))
                    res_09002.append(cell)
                    num_09002 = num_09002 + 1
            # 09003.AES-ECB弱加密风险检测.
            # aes_ecb_pattern = re.compile(r'^\s*(.*AES/ECB/.+Padding.*);', re.M)
            aes_ecb_obj = Regex.aes_ecb_pattern.findall(java_content)
            for scan_res in aes_ecb_obj:
                # print('09003 # %s: %s' % (show_java_file_path, scan_res))
                cell = '09003 # %s: %s' % (show_java_file_path, scan_res)
                res_09003.append(cell)
                num_09003 = num_09003 + 1
            # 09004.IVParameterSpec不安全初始化向量检测
            # iv_parameter_spec_pattern = re.compile(r'new\s+IvParameterSpec\((\w+)\)', re.M)
            ivs = Regex.iv_parameter_spec_pattern.findall(java_content)
            for iv in ivs:
                # byte[] iv = { 0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00 }
                const_iv = re.search(
                    r'byte\[\]\s+%s\s*=\s*{\s*(\dx\d\d\s*,\s*)+\dx\d\d\s*}' % iv,
                    java_content,
                    re.M | re.I)
                # print('09004 # %s: %s' % (show_java_file_path, const_iv.group(0)))
                cell = '09004 # %s: %s' % (show_java_file_path, const_iv.group(0))
                res_09004.append(cell)
                num_09004 = num_09004 + 1
            # 09005.RSA中不使用Padding风险检测
            # rsa_no_padding_pattern = re.compile(r'^\s*(.*RSA/(\w){3}/NoPadding.*);', re.M)
            rsa_no_padding_obj = Regex.rsa_no_padding_pattern.findall(java_content)
            for scan_res in rsa_no_padding_obj:
                # print('09005 # %s: %s' % (show_java_file_path, scan_res))
                cell = '09005 # %s: %s' % (show_java_file_path, scan_res)
                res_09005.append(cell)
                num_09005 = num_09005 + 1

            # 10001.敏感信息检测
            telephone = Regex.telephone_pattern.findall(java_content)
            email = Regex.email_pattern.findall(java_content)
            identity_code = Regex.identity_code_pattern.findall(java_content)
            for scan_res in telephone:
                # print('10001 # %s: 手机号(%s)' % (show_java_file_path, scan_res[0]))
                cell = '10001 # %s: 手机号(%s)' % (show_java_file_path, scan_res[0])
                res_10001.append(cell)
                num_10001 = num_10001 + 1
            for scan_res in email:
                # print('10001 # %s: email(%s)' % (show_java_file_path, scan_res))
                cell = '10001 # %s: email(%s)' % (show_java_file_path, scan_res)
                res_10001.append(cell)
                num_10001 = num_10001 + 1
            for scan_res in identity_code:
                # print('10001 # %s: 身份证号(%s)' % (show_java_file_path, scan_res))
                cell = '10001 # %s: 身份证号(%s)' % (show_java_file_path, scan_res)
                res_10001.append(cell)
                num_10001 = num_10001 + 1

            # 10002.剪贴板敏感信息泄露风险检测
            clip_data = Regex.clip_data_pattern.findall(java_content)
            for scan_res in clip_data:
                # print('10002 # %s: 检测到剪贴板有保存信息 - %s' % (show_java_file_path, scan_res))
                cell = '10002 # %s: 检测到剪贴板有保存信息 - %s' % (show_java_file_path, scan_res)
                res_10002.append(cell)
                num_10002 = num_10002 + 1

            # 10003.Intent敏感数据泄露风险检测
            intent_setflag = Regex.intent_setflag_pattern.findall(java_content)
            for scan_res in intent_setflag:
                # print('10003 # %s: intent设置了标志位FLAG_ACTIVITY_NEW_TASK - %s' % (show_java_file_path, scan_res))
                cell = '10003 # %s: intent设置了标志位FLAG_ACTIVITY_NEW_TASK - %s' % (show_java_file_path, scan_res)
                res_10003.append(cell)
                num_10003 = num_10003 + 1

            # 10004.PendingIntent误用风险
            pending_intent_names = Regex.pending_intent_pattern.findall(java_content)
            for name in pending_intent_names:
                flag_1 = re.search(r'%s\.setAction' % name[2], java_content, re.M)
                flag_2 = re.search(r'%s\.setClass' % name[2], java_content, re.M)
                flag_3 = re.search(r'%s\.setClassName' % name[2], java_content, re.M)
                flag_4 = re.search(r'%s\.setClipData' % name[2], java_content, re.M)
                flag_5 = re.search(r'%s\.setComponent' % name[2], java_content, re.M)
                if flag_1 or flag_2 or flag_3 or flag_4 or flag_5:
                    pass
                else:
                    # print('10004 # %s: 使用了空intent构造PendingIntent - %s' % (show_java_file_path, name[0]))
                    cell = '10004 # %s: 使用了空intent构造PendingIntent - %s' % (show_java_file_path, name[0])
                    res_10004.append(cell)
                    num_10004 = num_10004 + 1

            # 10005.密钥硬编码
            # SecretKey secretKey = new SecretKeySpec(key, "AES");
            secretkeyspec = Regex.secretkeyspec_pattern.findall(java_content)
            secretkeyspec = list(set(secretkeyspec))  # list去重
            for key_name in secretkeyspec:
                # byte[] key = str.getBytes();
                key_string = re.search(r'%s\s*=\s*(\w*).getBytes' % key_name, java_content, re.M)
                if key_string:
                    key_string_value = re.search(r'String\s+%s.*' % key_string.group(1), java_content, re.M)
                    if key_string_value:
                        # print('10005 # %s: 发现密钥硬编码 - %s' % (show_java_file_path, key_string_value.group(0)))
                        cell = '10005 # %s: 发现密钥硬编码 - %s' % (show_java_file_path, key_string_value.group(0))
                        res_10005.append(cell)
                        num_10005 = num_10005 + 1

            # 10007.BASE64安全检测
            base64_strs = Regex.base64_pattern.findall(java_content)
            for base64_str in base64_strs:
                # 增加限制条件，一般有意义base64字符串长度应该在25以上
                if len(base64_str[0]) > 25:
                    decode_byte_str = base64.b64decode(bytes(base64_str[0], 'utf8'))
                    try:
                        decode_str = str(decode_byte_str, 'utf-8')
                        # print('10007 # %s: Base64(%s) -> %s' % (show_java_file_path, base64_str[0], decode_str))
                        cell = '10007 # %s: Base64(%s) -> %s' % (show_java_file_path, base64_str[0], decode_str)
                        res_10007.append(cell)
                        num_10007 = num_10007 + 1
                    except UnicodeDecodeError:
                        pass  # 字符串解码失败，一般都是无意义的string

            # 10008.文件全局读写漏洞检测
            # MODE_WORLD_READABLE / MODE_WORLD_WRITEABLE -> MODE_PRIVATE
            # openFileOutput(String name, int mode)
            # getDir(String name, int mode)
            # getSharedPreferences(string name,int mode)
            openfile_output_sentences = Regex.openfile_output_pattern.findall(java_content)
            for sentence in openfile_output_sentences:
                # print('10008 # %s: %s' % (show_java_file_path, sentence[0]))
                cell = '10008 # %s: %s' % (show_java_file_path, sentence[0])
                res_10008.append(cell)
                num_10008 = num_10008 + 1
            getdir_sentences = Regex.getdir_pattern.findall(java_content)
            for sentence in getdir_sentences:
                # print('10008 # %s: %s' % (show_java_file_path, sentence[0]))
                cell = '10008 # %s: %s' % (show_java_file_path, sentence[0])
                res_10008.append(cell)
                num_10008 = num_10008 + 1
            getsharedprefer_sentences = Regex.getsharedprefer_pattern.findall(java_content)
            for sentence in getsharedprefer_sentences:
                # print('10008 # %s: %s' % (show_java_file_path, sentence[0]))
                cell = '10008 # %s: %s' % (show_java_file_path, sentence[0])
                res_10008.append(cell)
                num_10008 = num_10008 + 1

            # 10009.日志泄露风险检测
            logs = Regex.log_pattern.findall(java_content)
            for log in logs:
                # print('10009 # %s: %s' % (show_java_file_path, log))
                # if package_str in tran_java_file_path:
                cell = '10009 # %s: %s' % (show_java_file_path, log)
                res_10009.append(cell)
                num_10009 = num_10009 + 1

            # 11001.安全相关的函数检测
            safe_functions = Regex.safe_function_pattern.findall(java_content)
            for fun in safe_functions:
                # print('11001 # %s: %s' % (show_java_file_path, fun[0]))
                cell = '11001 # %s: %s' % (show_java_file_path, fun[0])
                res_11001.append(cell)
                num_11001 = num_11001 + 1

            # 11003.运行命令检测
            runtime_instances = Regex.getruntime_pattern.findall(java_content)
            for instance in runtime_instances:
                exec_operations = re.findall(r'\s*(.*%s\.exec.*);' % instance, java_content, re.M)
                for operation in exec_operations:
                    # print('11003 # %s: %s' % (show_java_file_path, operation))
                    cell = '11003 # %s: %s' % (show_java_file_path, operation)
                    res_11003.append(cell)
                    num_11003 = num_11003 + 1

            # 11004.Native Library加载检测
            load_library = Regex.load_library_pattern.findall(java_content)
            for scan_res in load_library:
                # print('11004 # %s: %s' % (show_java_file_path, scan_res))
                cell = '11004 # %s: %s' % (show_java_file_path, scan_res)
                res_11004.append(cell)
                num_11004 = num_11004 + 1

            # 11005.外部动态加载DEX检测
            dexclassloader = Regex.dexclassloader_pattern.findall(java_content)
            for scan_res in dexclassloader:
                # print('11005 # %s: %s' % (show_java_file_path, scan_res))
                cell = '11005 # %s: %s' % (show_java_file_path, scan_res)
                res_11005.append(cell)
                num_11005 = num_11005 + 1

            # 11006.root代码检测
            root_execs = Regex.root_exec_pattern.findall(java_content)
            for root_exec in root_execs:
                # print('11006 # %s: %s' % (show_java_file_path, root_exec))
                cell = '11006 # %s: %s' % (show_java_file_path, root_exec)
                res_11006.append(cell)
                num_11006 = num_11006 + 1

            # 11007.获取IMEI和Device ID敏感信息代码检测
            get_device_id_sentences = Regex.getdeviceid_pattern.findall(java_content)
            for scan_res in get_device_id_sentences:
                # print('11007 # %s: %s' % (show_java_file_path, scan_res))
                cell = '11007 # %s: %s' % (show_java_file_path, scan_res)
                res_11007.append(cell)
                num_11007 = num_11007 + 1

            # 11008.获取AndroidID敏感信息代码检测
            get_android_id_sentences = Regex.secure_androidid_pattern.findall(java_content)
            for scan_res in get_android_id_sentences:
                # print('11008 # %s: %s' % (show_java_file_path, scan_res))
                cell = '11008 # %s: %s' % (show_java_file_path, scan_res)
                res_11008.append(cell)
                num_11008 = num_11008 + 1

            # 11009.发送SMS敏感代码检测
            send_sms_sentences = Regex.send_sms_pattern.findall(java_content)
            for scan_res in send_sms_sentences:
                # print('11008 # %s: %s' % (show_java_file_path, scan_res[0]))
                cell = '11008 # %s: %s' % (show_java_file_path, scan_res[0])
                res_11009.append(cell)
                num_11009 = num_11009 + 1

            # 11010.文件删除代码检测
            file_objs = Regex.getfile_pattern.findall(java_content)
            for file_obj in file_objs:
                delete_sentences = re.findall(r'\s*(.*%s\.delete.*);' % file_obj, java_content, re.M)
                for scan_res in delete_sentences:
                    # print('11010 # %s: %s' % (show_java_file_path, scan_res))
                    cell = '11010 # %s: %s' % (show_java_file_path, scan_res)
                    res_11010.append(cell)
                    num_11010 = num_11010 + 1

            # 11011.signature代码检测
            getsignature_sentences = Regex.signature_pattern.findall(java_content)
            for scan_res in getsignature_sentences:
                # print('11011 # %s: %s' % (show_java_file_path, scan_res))
                cell = '11011 # %s: %s' % (show_java_file_path, scan_res)
                res_11011.append(cell)
                num_11011 = num_11011 + 1

            # 12001.Fragment注入漏洞CVE-2013-6271检测
            isvalid_fragment = Regex.isvalid_fragment_pattern.search(java_content)
            if isvalid_fragment and (tran_java_file_path in result_component_exported_true) and int(min_sdk_str) < 19:
                # print('12001 # %s: PreferenceActivity.isValidFragment()方法存在安全隐患' % show_java_file_path)
                cell = '12001 # %s: PreferenceActivity.isValidFragment()方法存在安全隐患' % show_java_file_path
                res_12001.append(cell)
                num_12001 = num_12001 + 1

            # 12003.随机数生成漏洞
            if int(min_sdk_str) < 17:
                set_seed = Regex.set_seed_pattern.findall(java_content)
                for scan_res in set_seed:
                    # print('12003 # %s: %s - 使用自定义的种子代替系统种子不安全' % (show_java_file_path, scan_res))
                    cell = '12003 # %s: %s - 使用自定义的种子代替系统种子不安全' % (show_java_file_path, scan_res)
                    res_12003.append(cell)
                    num_12003 = num_12003 + 1
    # Part 2----------------------------------------------------------------------------------------------- #
    # 05009.manifest中定义组件未实现检测
    # print('# 05009')
    for obj in component_obj:
        if obj in source_component_list:
            # print('Manifest定义的%s组件有源码实现' % obj)
            pass
        else:
            # print('Manifest定义的%s组件无源码实现' % obj)
            res_05009.append(obj)
            num_05009 = num_05009 + 1

    # 05010.Debug或Test敏感测试组件泄露检测
    # print('# 05010')
    for obj in component_obj:
        debug_test_obj = Regex.debug_test_pattern.search(obj)
        if debug_test_obj:
            # print('%s组件是测试组件，建议在发布时删除' % obj)
            res_05010.append(obj)
            num_05010 = num_05010 + 1
        else:
            pass

    # 07001.SQLite数据库加密(SQLCipher)检测
    if 'net.sqlcipher.database.SQLiteDatabase' in source_component_list:
        # print('07001 # SQLite使用了SQLCipher开源库')
        res_07001.append('07001 # SQLite使用了SQLCipher开源库')
        num_07001 = num_07001 + 1

    # 07002.SQLite数据库(SQLite Encryption Extension - SEE) 检测
    if 'org.sqlite.database.sqlite.SQLiteDatabase' in source_component_list:
        # print('07002 # SQLite使用了SEE加密扩展插件')
        res_07002.append('07002 # SQLite使用了SEE加密扩展插件')
        num_07002 = num_07002 + 1

    # 11002.安全相关的类检测
    if constant.ONLY_IN_PACKAGE == 1:
        if package_str in tran_java_file_path:
            for class_name in source_component_list:
                flag = Regex.safe_class_pattern.search(class_name)
                if flag:
                    # print('11002 # %s' % class_name)
                    res_11002.append(class_name)
                    num_11002 = num_11002 + 1
    else:
        for class_name in source_component_list:
            flag = Regex.safe_class_pattern.search(class_name)
            if flag:
                # print('11002 # %s' % class_name)
                res_11002.append(class_name)
                num_11002 = num_11002 + 1

    # 12002.SQLite数据库日志泄露漏洞(CVE - 2011 - 3901)检测
    if int(min_sdk_str) < 14:
        # print('12002 # 您应用所支持的最小SDK存在SQLite数据库日志泄露漏洞')
        res_12002 = '12002 # 您应用所支持的最小SDK存在SQLite数据库日志泄露漏洞'
        num_12002 = num_12002 + 1

    # 将扫描结果存储进入数据库
    save(db, file_name, '05008', res_05008, 1, num_05008)
    save(db, file_name, '05009', res_05009, 2, num_05009)
    save(db, file_name, '05010', res_05010, 2, num_05010)
    save(db, file_name, '05011', res_05011, 1, num_05011)

    save(db, file_name, '06001', res_06001, 0, num_06001)
    save(db, file_name, '06002', res_06002, 0, num_06002)
    save(db, file_name, '06003', res_06003, 3, num_06003)
    save(db, file_name, '06004', res_06004, 0, num_06004)
    save(db, file_name, '06005', res_06005, 2, num_06005)
    save(db, file_name, '06006', res_06006, 2, num_06006)
    save(db, file_name, '06007', res_06007, 2, num_06007)
    save(db, file_name, '06008', res_06008, 2, num_06008)
    save(db, file_name, '06009', res_06009, 1, num_06009)

    save(db, file_name, '07001', res_07001, -2, num_07001)  # level = -2 展示
    save(db, file_name, '07002', res_07002, -2, num_07002)

    save(db, file_name, '08001', res_08001, 0, num_08001)
    save(db, file_name, '08002', res_08002, 0, num_08002)
    save(db, file_name, '08003', res_08003, 0, num_08003)
    save(db, file_name, '08005', res_08005, 1, num_08005)

    save(db, file_name, '09001', res_09001, 1, num_09001)
    save(db, file_name, '09002', res_09002, 1, num_09002)
    save(db, file_name, '09003', res_09003, 1, num_09003)
    save(db, file_name, '09004', res_09004, 1, num_09004)
    save(db, file_name, '09005', res_09005, 1, num_09005)

    save(db, file_name, '10001', res_10001, -2, num_10001)
    save(db, file_name, '10002', res_10002, -2, num_10002)
    save(db, file_name, '10003', res_10003, 0, num_10003)
    save(db, file_name, '10004', res_10004, 2, num_10004)
    save(db, file_name, '10005', res_10005, 1, num_10005)
    save(db, file_name, '10007', res_10007, -2, num_10007)
    save(db, file_name, '10008', res_10008, 2, num_10008)
    save(db, file_name, '10009', res_10009, 0, num_10009)

    save(db, file_name, '11001', res_11001, -2, num_11001)
    save(db, file_name, '11002', res_11002, -2, num_11002)
    save(db, file_name, '11003', res_11003, 0, num_11003)
    save(db, file_name, '11004', res_11004, 0, num_11004)
    save(db, file_name, '11005', res_11005, 3, num_11005)
    save(db, file_name, '11006', res_11006, 0, num_11006)
    save(db, file_name, '11007', res_11007, 0, num_11007)
    save(db, file_name, '11008', res_11008, 0, num_11008)
    save(db, file_name, '11009', res_11009, 0, num_11009)
    save(db, file_name, '11010', res_11010, 0, num_11010)
    save(db, file_name, '11011', res_11011, 0, num_11011)

    save(db, file_name, '12001', res_12001, 2, num_12001)
    save(db, file_name, '12002', res_12002, 1, num_12002)
    save(db, file_name, '12003', res_12003, 3, num_12003)

    # 关闭存储结果的文件
    # res.close()

    # 关闭数据库
    mysql.close_db(db)


def save(db, apk_name, identity, res, level, num):
    if num == 0:
        mysql.insert_into_db(db, apk_name, identity, '安全', -1, 0)
    else:
        mysql.insert_into_db(db, apk_name, identity, '\n'.join(res), level, num)


def activity_intent_browsable_search(activity_obj):
    res_list = []
    num = 0
    for text in activity_obj:
        activity_name = ''
        activity_name_obj = Regex.component_name_pattern.search(text)
        if activity_name_obj:
            activity_name = activity_name_obj.group(1)
        if Regex.activity_intent_browsable_pattern.search(text):
            # print('activity(%s)的定义了android.intent.category.BROWSABLE，这是不安全的' % activity_name)
            res_list.append('activity(%s)的定义了android.intent.category.BROWSABLE，这是不安全的' % activity_name)
            num = num + 1
        else:
            # print('activity(%s)未定义android.intent.category.BROWSABLE，这是安全的' % activity_name)
            pass
        # res = '\n'.join(res_list)
    return {'res_list': res_list, 'num': num}


def provider_grant_uri_permission_search(provider_obj):
    res_list = []
    num = 0
    for text in provider_obj:
        provider_name = ''
        provider_name_obj = Regex.component_name_pattern.search(text)
        if provider_name_obj:
            provider_name = provider_name_obj.group(1)
        if Regex.provider_grant_uri_permission_pattern.search(text):
            # print('provider(%s)的grantUriPermissions="true"，这是不安全的' % provider_name)
            res_list.append('provider(%s)的grantUriPermissions="true"，这是不安全的' % provider_name)
            num = num + 1
        else:
            # print('provider(%s)grantUriPermissions设置是安全的' % provider_name)
            pass
        # res = '\n'.join(res_list)
    return {'res_list': res_list, 'num': num}


def component_exported_search(component_item, component_obj):
    res_list = []
    exported_list = []
    num = 0
    for text in component_obj:
        component_name = ''
        component_exported = ''
        component_permission = ''
        component_filter = ''

        component_name_obj = Regex.component_name_pattern.search(text)
        component_exported_obj = Regex.component_exported_pattern.search(text)
        component_permission_obj = Regex.component_permission_pattern.search(text)
        component_filter_obj = Regex.component_filter_pattern.search(text)
        if component_name_obj:
            component_name = component_name_obj.group(1)
        if component_exported_obj:
            component_exported = component_exported_obj.group(1)
        if component_permission_obj:
            component_permission = component_permission_obj.group(1)
        if component_filter_obj:
            component_filter = component_filter_obj.group(0)
        # 有intent-filter -> exported default为true
        # 无intent-filter -> exported default为false
        # intent-filter标签中至少包含一个action标签，官方文档指明must contain

        if component_exported == 'false':
            pass  # 安全
        elif component_permission == 'signature' or component_permission == 'signatureOrSystem':
            pass  # 安全
        elif component_exported == 'true' and component_filter == '':
            # print(component_item + '(%s)的exported="true"且权限设置不合理' % component_name)
            res_list.append(component_item + '(%s)的exported="true"且权限设置不合理' % component_name)
            exported_list.append(component_name)
            num = num + 1
        elif component_exported == '' and component_filter != '':
            # print(component_item + '(%s)的exported未设置，包含intent-filter标签，且权限设置不合理' % component_name)
            res_list.append(component_item + '(%s)的exported未设置，包含intent-filter标签，且权限设置不合理' % component_name)
            exported_list.append(component_name)
            num = num + 1
        elif component_exported == 'true' and component_filter != '':
            # print(component_item + '(%s)的exported="true"，包含intent-filter标签，且权限设置不合理' % component_name)
            res_list.append(component_item + '(%s)的exported="true"，包含intent-filter标签，且权限设置不合理' % component_name)
            exported_list.append(component_name)
            num = num + 1

        else:
            pass  # 安全

    # res = '\n'.join(res_list)
    return {'exported_list': exported_list, 'num': num}
