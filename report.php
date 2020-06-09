<?php 
    #Include data.php and authenticate.php
    include 'modules/class/authenticate.php';
    include 'modules/class/data.php';

    if(check_cookie() == 0) {
        session_start();
        $user_info = get_user_info();
        $report_data = get_report_data();
    } else {
        $code = check_cookie();
        header("Location: modules/class/error.php?code=$code");
    }

?>

<!DOCTYPE html>
<html lang="zh">
<head>

    <?php include 'modules/ui/header.php'; ?>

    <!-- Bootstrap Core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="dist/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="dist/css/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="dist/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Kenny Bootstrap Custom CSS -->
    <link href="dist/css/report-style.css" rel="stylesheet" type="text/css">

</head>

<body><div id="wrapper">

    <div id="page-wrapper" style="min-height: 653px;">
        <div class="row">
            <div class="col-lg-12">
                <h1>卓护平台检测报告</h1>
                <!--<h3>安全评分：32</h3>-->
                <h3><?php echo $report_data['apk_real_name']; ?></h3>
                <h3 class="page-header">时间：<?php echo $report_data['date']; ?></h3>
            </div>
        </div>
  
        <div class="row">
            <div class="col-lg-12">
                <!--基本信息-->
                <div class="row-fluid" id="file-index0">
                    <div class="row">
                        <div class="sm-data-box bg-red col-lg-2 col-xs-6 ma-5">
                            <div class="row ma-0">
                                <div class="col-xs-6 text-center data-wrap-left">
                                    <h5 class="txt-light">高危</h5>
                                    <span class="txt-light counter counter-anim"><?php echo $report_data['high']; ?></span>
                                </div>
                                <div class="col-xs-6 text-center data-wrap-right">
                                    <h5 class="txt-light">中危</h5>
                                    <span class="txt-light counter counter-anim"><?php echo $report_data['middle']; ?></span>
                                </div>
                            </div>
                        </div>                        
                        <div class="sm-data-box bg-yellow col-lg-2 col-xs-6 ma-5">
                            <div class="row ma-0">
                                <div class="col-xs-6 text-center data-wrap-left">
                                    <h5 class="txt-light">低危</h5>
                                    <span class="txt-light counter"><?php echo $report_data['low']; ?></span>
                                </div>
                                <div class="col-xs-6 text-center data-wrap-right">
                                    <h5 class="txt-light">提醒</h5>
                                    <span class="txt-light counter"><?php echo $report_data['warning']; ?></span>
                                </div>
                            </div>
                        </div>
                        <div class="sm-data-box bg-green col-lg-2 col-xs-6 ma-5">
                            <div class="row ma-0">
                                <div class="col-xs-5 text-center pa-0 icon-wrap-left">
                                    <i class="icon-lock txt-light"></i>
                                </div>
                                <div class="col-xs-7 text-center data-wrap-right">
                                    <h5 class="txt-light">应用等级</h5>
                                    <span class="txt-light counter counter-anim">
                                        <?php
                                            switch ($report_data['level']) {
                                                case -1:
                                                    echo '安全';
                                                    break;
                                                case 0:
                                                    echo '合格';
                                                    break;
                                                case 1:
                                                    echo '警告';
                                                    break;
                                                case 2:
                                                    echo '危险';
                                                    break;
                                                default:
                                                    echo 'error';
                                                    break;
                                            }
                                        ?>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="sm-data-box bg-blue col-lg-2 col-xs-6 ma-5">
                            <div class="row ma-0">
                                <div class="col-xs-5 text-center pa-0 icon-wrap-left">
                                    <i class="icon-eye txt-light"></i>
                                </div>
                                <div class="col-xs-7 text-center data-wrap-right">
                                    <h5 class="txt-light">安全评分</h5>
                                    <span class="txt-light counter counter-anim"><?php echo $report_data['score']; ?></span>
                                </div>
                            </div>
                        </div>
                    </div>        
                           
                    <div class="row mt-20">
                        <div class="col-md-6">
                          <div class=" box box-widget">
                            
                          <table class="table">
                            <thead>
                              <tr>
                                <th></th>
                                <th></th>
                              </tr>
                            </thead>
                            <tbody>
                             
                              <tr>
                                <td>文件名</td>
                                  <td><?php echo $report_data['apk_real_name']; ?></td>
                              </tr>

                              <tr>
                                <td>文件大小</td>
                                <td><?php echo $report_data['file_size']; ?></td>
                              </tr>
                              <tr>
                                <td>MD5</td>
                                <td><?php echo $report_data['file_md5']; ?></td>
                              </tr>
                              <tr>
                                <td>包名</td>
                                <td><?php echo $report_data['package']; ?></td>
                              </tr>
                              <tr>
                                <td>Main Activity</td>
                                <td><?php echo $report_data['main_activity']; ?></td>
                              </tr>
                              <tr>
                                <td>Min SDK</td>
                                <td><?php echo $report_data['min_sdk']; ?></td>
                              </tr>
                              
                              <tr>
                                <td>Target SDK</td>
                                <td><?php echo $report_data['target_sdk']; ?></td>
                              </tr>

                            </tbody>
                          </table>
                          </div>
                        </div>             
                    </div>
                </div>
                <!--基本信息-->

                <div class="row-fluid">
                    <h3>应用等级与评分</h3>
                    <table class="table table-bordered" style="max-width: 300px">
                        <thead>
                            <tr>
                                <th>应用安全等级</th>
                                <th>分数范围</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr >              
                                <td>安全</td>
                                <td>90 ～ 100</td>
                            </tr>

                           <tr >              
                                <td>合格</td>
                                <td>70 ～ 89</td>
                            </tr>
                            <tr >              
                                <td>警告</td>
                                <td>50 ～ 69</td>
                            </tr>
                            <tr >              
                                <td>危险</td>
                                <td>< 50</td>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>

                <!--权限相关-->
                <div class="row-fluid" id="file-index1">
                    <h3>权限等级说明</h3>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>权限等级</th>
                                <th>英文</th>
                                <th>说明</th>
                                <th style="min-width:80px">表示</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr >              
                                <td>正常</td>
                                <td>normal</td>
                                <td>风险较低的权限，允许请求应用程序访问隔离的应用程序级功能，对其他应用程序，系统或用户的风险最小。</td>
                                <td>N</td>
                            </tr>

                            <tr>                     
                                <td>危险</td>
                                <td>dangerous</td>
                                <td>一种风险较高的权限，可以使请求的应用程序访问私有用户数据或控制可能对用户产生负面影响的设备。</td>
                                <td>D</td>
                            </tr>    
                            <tr>                     
                                <td>签名</td>
                                <td>signature</td>
                                <td>仅当请求的应用程序使用与声明权限的应用程序相同的证书进行签名时系统授予的权限。</td>
                                <td>S</td>
                            </tr> 
                            <tr>                     
                                <td>签名/特权</td>
                                <td>signature/Privileged</td>
                                <td>在API级别23后推荐使用"signatureOrSystem"表示。限用于某些特殊情况，往往是手机的供应商会用到该权限等级，比如将应用程序内置到系统映像中，并且需要共享特定的功能。一般的应用不应该申请该功能。</td>
                                <td>S/P</td>
                            </tr>   
                            <tr>                     
                                <td>不允许被第三方应用使用</td>
                                <td>Not for Use by third-party applications</td>
                                <td>Android系统自带的应用以外的，也就是一般开发者开发的Android应用，比如QQ、微博、微信、今日头条、抖音和王者荣耀等等，都是第三方应用，这些应用都是不能拥有NU标注的权限的。</td>
                                <td>NU</td>
                            </tr>    
                            <tr>                     
                                <td>已弃用</td>
                                <td>out</td>
                                <td>已弃用包括三种情况。一是从API级别高于某一等级后废弃该权限，用O-xxx来表示从API级别xxx以后废弃该权限；二是该权限被某一权限替代；三是该权限被永久废弃，用O-all来表示。</td>
                                <td>O</td>
                            </tr>        
                            
                        </tbody>
                    </table>

                    <h3>权限列表</h3>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>名称</th>
                                <th>说明</th>
                                <th style="min-width:80px">提示</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php echo $report_data['permission']; //数据库中的permission的扫描结果直接就是以HTML的格式存储的 ?>
                        </tbody>
                  </table>
                </div>
                <!--权限列表-->

                <!--四大组件-->
                <div class="row-fluid" id="file-index2">
                    <h3>四大组件</h3>
                    <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>组件名称</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                  <div class="bs">
                                    <p>
                                        <a role="button" data-toggle="collapse" href="#activity" aria-expanded="true" aria-controls="collapseExample">
                                            Activity组件
                                        </a>
                                    </p>
                                    <div class="collapse" id="activity">
                                        <div>
                                            <?php
                                                $result = $report_data['activity'];
                                                $result = preg_replace('/\n/', '<br/>', $result);
                                                $result = preg_replace('/ /', '&nbsp', $result);
                                                echo $result; 
                                            ?>
                                          </div>
                                    </div>
                                  </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                  <div class="bs">
                                    <p>
                                      <a role="button" data-toggle="collapse" href="#service" aria-expanded="true" aria-controls="collapseExample">
                                        Service组件
                                      </a>
                                    </p>
                                    <div class="collapse" id="service">
                                        <div>
                                            <?php
                                                $result = $report_data['service']; 
                                                $result = preg_replace('/\n/', '<br/>', $result);
                                                $result = preg_replace('/ /', '&nbsp', $result);
                                                echo $result; 
                                            ?>
                                        </div>
                                    </div>
                                  </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                  <div class="bs">
                                    <p>
                                        <a role="button" data-toggle="collapse" href="#BroadcastReceiver" aria-expanded="true" aria-controls="collapseExample">
                                            BroadcastReceiver组件
                                        </a>
                                    </p>
                                    <div class="collapse" id="BroadcastReceiver">
                                        <div>
                                           <?php
                                                $result = $report_data['receiver'];
                                                $result = preg_replace('/\n/', '<br/>', $result);
                                                $result = preg_replace('/ /', '&nbsp', $result);
                                                echo $result; 
                                           ?>
                                        </div>
                                    </div>
                                  </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                  <div class="bs">
                                    <p>
                                        <a role="button" data-toggle="collapse" href="#ContentProvider" aria-expanded="true" aria-controls="collapseExample">
                                            ContentProvider组件
                                        </a>
                                    </p>
                                    <div class="collapse" id="ContentProvider">
                                        <div>
                                            <?php
                                                $result = $report_data['provider'];
                                                $result = preg_replace('/\n/', '<br/>', $result);
                                                $result = preg_replace('/ /', '&nbsp', $result);
                                                echo $result; 
                                            ?>
                                        </div>
                                    </div>
                                  </div>
                                </td>
                            </tr>
                            
                        </tbody>
                    </table>
                    </div>
                </div>
                <!--四大组件-->

                <h3 class="sub-header" id="file-index4">静态扫描发现风险点</h3>
                
                <div class="table-responsive">
                    <table class="table table-striped" style="table-layout:fixed">
                        <thead>
                            <tr>
                               
                                <th style="width:100px">风险等级</th>
                                 <th>风险名称</th>

                            </tr>
                        </thead>
                        <tbody>
                            <?php
                                //扫描项的identity与title的映射
                                $title_map = array(
                                    '04001' => '04001.AndroidManifest文件中PermissionGroup检测',
                                    '04002' => '04002.AndroidManifest文件中系统权限使用检测',
                                    '04003' => '04003.AndroidManifest文件中ProtectionLevel权限检测',
                                    '04004' => '04004.AndroidManifest sharedUserId检测',
                                    '04005' => '04005.allowBackup标志检测',
                                    '04006' => '04006.Debuggable配置检测',
                                    '04007' => '04007.非必要权限检测',
                                    '04008' => '04008.app最低版本检测',
                                    '05001' => '05001.Activity组件导出检测',
                                    '05002' => '05002.Service组件导出检测',
                                    '05003' => '05003.Receiver组件导出检测',
                                    '05004' => '05004.Provider组件导出检测',
                                    '05005' => '05005.Provider: grant-uri-permission属性检测',
                                    '05006' => '05006.Intent-Based攻击检测',
                                    '05007' => '05007.Intent Scheme URL漏洞攻击检测',
                                    '05008' => '05008.应用本地拒绝服务器漏洞检测',
                                    '05009' => '05009.Manifest中定义组件未实现检测',
                                    '05010' => '05010.Debug或Test敏感测试组件泄露检测',
                                    '05011' => '05011.Intent不安全反射风险检测',
                                    '06001' => '06001.Webview远程执行漏洞检测',
                                    '06002' => '06002.WebView潜在XSS攻击检测',
                                    '06003' => '06003.WebView本地文件访问漏洞检测',
                                    '06004' => '06004.WebView密码明文存储漏洞检测',
                                    '06005' => '06005.主机名弱校验检测',
                                    '06006' => '06006.证书弱校验检测',
                                    '06007' => '06007.间人攻击漏洞检测',
                                    '06008' => '06008.WebView不校验证书漏洞检测',
                                    '06009' => '06009.WebView组件系统隐藏接口未移除漏洞',
                                    '07001' => '07001.SQLite数据库加密(SQLCipher)检测',
                                    '07002' => '07002.SQLite数据库加密拓展(SQLite Encryption Extension,SEE)检测',
                                    '07003' => '07003.SQLite数据库的对称密钥检测',
                                    '07004' => '07004.SQLite Database Transaction Deprecated（SQL注入）检测',
                                    '07005' => '07005.Databases任意读写漏洞检测',
                                    '08001' => '08001.SSL不安全组件检测',
                                    '08002' => '08002.SSL连接检测',
                                    '08003' => '08003.HttpHost检测',
                                    '08004' => '08004.HttpURLConnection漏洞检测',
                                    '08005' => '08005.网络端口开放威胁检测',
                                    '09001' => '09001.DES弱加密风险检测',
                                    '09002' => '09002.不安全的密钥长度风险检测',
                                    '09003' => '09003.AES-ECB弱加密模式风险检测',
                                    '09004' => '09004.IVParameterSpec不安全初始化向量风险检测',
                                    '09005' => '09005.RSA中不使用Padding风险检测',
                                    '09006' => '09006.检测keystore是否使用密码保护',
                                    '10001' => '10001.敏感信息检测',
                                    '10002' => '10002.剪贴板敏感信息泄露风险检测',
                                    '10003' => '10003.Intent敏感数据泄露风险检测',
                                    '10004' => '10004.PendingIntent误用风险',
                                    '10005' => '10005.密钥硬编码风险检测',
                                    '10006' => '10006.数据或程序加载检查',
                                    '10007' => '10007.BASE64安全检测',
                                    '10008' => '10008.文件全局读写漏洞检测',
                                    '10009' => '10009.日志泄露风险检测',
                                    '10010' => '10010.外部加载Dex检测',
                                    '10011' => '10011.外部存储路径检测',
                                    '10012' => '10012.明文数字证书风险',
                                    '11001' => '11001.安全相关的函数检测',
                                    '11002' => '11002.安全相关的类检测',
                                    '11003' => '11003.运行命令检测',
                                    '11004' => '11004.Native Library加载检测',
                                    '11005' => '11005.外部动态加载DEX检测',
                                    '11006' => '11006.root代码检测',
                                    '11007' => '11007.获取IMEI和Device ID敏感信息代码检测',
                                    '11008' => '11008.获取Android ID敏感信息代码检测',
                                    '11009' => '11009.发送SMS敏感代码检测',
                                    '11010' => '11010.文件删除代码检测',
                                    '11011' => '11011.signature代码检测',
                                    '12001' => '12001.fragment注入漏洞检测',
                                    '12002' => '12002.sqlite数据库日志泄露漏洞检测',
                                    '12003' => '12003.随机数生成漏洞检测'

                                );
                                $description_map = array(
                                    '04001' => 'PermissionGroup可以对permission进行一个逻辑上的分组。<br/>首先我们要明晰两个概念，&ltpermission&gt标签中的android:permissionGroup属性和&ltpermission-group&gt标签是两个不同的东西。可以不定义相应的&ltpermission-group&gt标签，但是如果在&ltpermission&gt标签有permissionGroup属性，那么值应该不为空。如果permissionGroup的属性为空，会导致权限定义无效，且其他app无法使用该权限。',

                                    '04002' => '若App如果使用了一些系统限制权限，诸如android.permission.WRITE_SECURE_SETTINGS和android.permission.INSTALL_PACKAGES，则该应用应该是设备自带的系统或Google自带的APP，并且应该放置在/system/app目录下，否则就是一个恶意APP。<br/>
                                        <p>若App使用下述权限，则该app有较高权限，要谨慎使用：</p>
                                        <p>android.permission.MOUNT_FORMAT_FILESYSTEMS</p>
                                        <p>android.permission.MOUNT_UNMOUNT_FILESYSTEMS</p>
                                        <p>android.permission.RESTART_PACKAGES</p>',

                                    '04003' => '由于应用自定义的permission的protectionLevel属性设置不当，会导致组件（如：content provider）数据泄露危险。最好的权限设置应为signature或signatureOrSystem，进而避免被第三方应用利用。',

                                    '04004' => '通过sharedUserId，可以让拥有同一个User Id的多个apk运行在同一个进程中，互相访问任意资源。将sharedUserId设置为android.uid.system，可以把app放到系统进程中，app将获得极大的权限。如果app同时有master key漏洞，容易导致被root。若 minSdkVersion<= 19，则说明其运行的系统可能存在mster key漏洞（Android系统 <= 4.4，即API Level <= 19存在master key漏洞）。此时若sharedUserId设置为android.uid.system，则标注为高危漏洞；若minSdkVersion >19 则是提醒等级。',

                                    '04005' => '当API Level>= 8时（其实小于8的API版本现在已经灭绝了），allowBackup这个标志被设置成true或不设置该标志位时，应用程序数据可以备份和恢复，adb调试备份允许恶意攻击者复制应用程序数据。',

                                    '04006' => '在AndroidManifest.xml中定义Debuggable项，如果该项被打开，app存在被恶意程序调试的风险，可能导致泄露敏感信息等问题。',
                                    '04007' => '<p>检测一些在生产环境中不必要使用的权限。</p><p>android.permission.ACCESS_MOCK_LOCATION该权限是使在模拟器中使用，用于获取模拟定位信息，安装在用户手机中的应用不应该申请该权限。</p>',
                                    '04008' => '罗列出跟最低版本相关的漏洞和bug，提醒开发者注意自己应用支持的最低版本的系统可能存在的问题。',
                                    '05001' => 'Activity组件对外暴露会导致数据泄露和恶意的dos攻击。',
                                    '05002' => 'Service组件对外暴露会导致数据泄露和恶意的dos攻击。',
                                    '05003' => 'Receiver组件对外暴露会导致数据泄露和恶意的dos攻击。',
                                    '05004' => 'Provider组件对外暴露会导致数据泄露和恶意的dos攻击。',
                                    '05005' => 'Provider: grant-uri-permission属性检测',
                                    '05006' => 'Intent-Based攻击检测',
                                    '05007' => 'Intent Scheme URL漏洞攻击检测',
                                    '05008' => '应用本地拒绝服务器漏洞检测',
                                    '05009' => 'manifest中定义组件未实现检测',
                                    '05010' => 'Debug或Test敏感测试组件泄露检测',
                                    '05011' => 'Intent不安全反射风险检测',
                                    '06001' => 'Webview远程执行漏洞检测',
                                    '06002' => 'WebView潜在XSS攻击检测',
                                    '06003' => 'WebView本地文件访问漏洞检测',
                                    '06004' => 'WebView密码明文存储漏洞检测',
                                    '06005' => '主机名弱校验检测',
                                    '06006' => '证书弱校验检测',
                                    '06007' => '中间人攻击漏洞检测',
                                    '06008' => 'WebView不校验证书漏洞检测',
                                    '06009' => 'WebView组件系统隐藏接口未移除漏洞',
                                    '07001' => 'SQLite数据库加密(SQLCipher)检测',
                                    '07002' => 'SQLite数据库加密拓展(SQLite Encryption Extension,SEE)检测',
                                    '07003' => 'SQLite数据库的对称密钥检测',
                                    '07004' => 'SQLite Database Transaction Deprecated（SQL注入）检测',
                                    '07005' => 'Databases任意读写漏洞检测',
                                    '08001' => 'SSL不安全组件检测',
                                    '08002' => 'SSL连接检测',
                                    '08003' => 'HttpHost检测',
                                    '08004' => 'HttpURLConnection漏洞检测',
                                    '08005' => '网络端口开放威胁检测',
                                    '09001' => '弱加密算法风险检测',
                                    '09002' => '不安全的密钥长度风险检测',
                                    '09003' => 'ECB弱加密模式风险检测',
                                    '09004' => 'IVParameterSpec不安全初始化向量风险检测',
                                    '09005' => 'RSA中不使用Padding风险检测',
                                    '09006' => '检测keystore是否使用密码保护',
                                    '10001' => '敏感信息检测',
                                    '10002' => '剪贴板敏感信息泄露风险检测',
                                    '10003' => 'Intent敏感数据泄露风险检测',
                                    '10004' => 'PendingIntent误用风险',
                                    '10005' => '密钥硬编码风险检测',
                                    '10006' => '数据或程序加载检查',
                                    '10007' => 'BASE64安全检测',
                                    '10008' => '文件全局读写漏洞检测',
                                    '10009' => '日志泄露风险检测',
                                    '10010' => '外部加载Dex检测',
                                    '10011' => '外部存储路径检测',
                                    '10012' => '明文数字证书风险',
                                    '11001' => '安全相关的函数检测',
                                    '11002' => '安全相关的类检测',
                                    '11003' => '运行命令检测',
                                    '11004' => 'Native Library加载检测',
                                    '11005' => '外部动态加载DEX检测',
                                    '11006' => 'root代码检测',
                                    '11007' => '获取IMEI和Device ID敏感信息代码检测',
                                    '11008' => '获取Android ID敏感信息代码检测',
                                    '11009' => '发送SMS敏感代码检测',
                                    '11010' => '文件删除代码检测',
                                    '11011' => 'signature代码检测',
                                    '12001' => 'fragment注入漏洞检测',
                                    '12002' => 'sqlite数据库日志泄露漏洞检测',
                                    '12003' => '随机数生成漏洞检测'
                                );
                                $advice_href_04 = 'https://www.kancloud.cn/yelbee111/annhub/987941';
                                $advice_map = array(
                                    '04001' => "<a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04002' => "<p>根据业务需求，如非必要，移除这些高级别权限。</p><a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04003' => "<a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04004' => "<p>采用API等级高于19的系统。若非特殊的需求，一般不会将sharedUserId设置为android.uid.system。<p><a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04005' => "<a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04006' => "<p>不设置debuggable选项，或者将其设置成false，推荐使用后面一种。</p><a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04007' => "<p>移除android.permission.ACCESS_MOCK_LOCATION权限</p><a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '04008' => "<a href='$advice_href_04' target='_blank'>$advice_href_04</a>",
                                    '05001' => 'Activity组件导出检测',
                                    '05002' => 'Service组件导出检测',
                                    '05003' => 'Receiver组件导出检测',
                                    '05004' => 'Provider组件导出检测',
                                    '05005' => 'Provider: grant-uri-permission属性检测',
                                    '05006' => 'Intent-Based攻击检测',
                                    '05007' => 'Intent Scheme URL漏洞攻击检测',
                                    '05008' => '应用本地拒绝服务器漏洞检测',
                                    '05009' => 'manifest中定义组件未实现检测',
                                    '05010' => 'Debug或Test敏感测试组件泄露检测',
                                    '05011' => 'Intent不安全反射风险检测',
                                    '06001' => 'Webview远程执行漏洞检测',
                                    '06002' => 'WebView潜在XSS攻击检测',
                                    '06003' => 'WebView本地文件访问漏洞检测',
                                    '06004' => 'WebView密码明文存储漏洞检测',
                                    '06005' => '主机名弱校验检测',
                                    '06006' => '证书弱校验检测',
                                    '06007' => '中间人攻击漏洞检测',
                                    '06008' => 'WebView不校验证书漏洞检测',
                                    '06009' => 'WebView组件系统隐藏接口未移除漏洞',
                                    '07001' => 'SQLite数据库加密(SQLCipher)检测',
                                    '07002' => 'SQLite数据库加密拓展(SQLite Encryption Extension,SEE)检测',
                                    '07003' => 'SQLite数据库的对称密钥检测',
                                    '07004' => 'SQLite Database Transaction Deprecated（SQL注入）检测',
                                    '07005' => 'Databases任意读写漏洞检测',
                                    '08001' => 'SSL不安全组件检测',
                                    '08002' => 'SSL连接检测',
                                    '08003' => 'HttpHost检测',
                                    '08004' => 'HttpURLConnection漏洞检测',
                                    '08005' => '网络端口开放威胁检测',
                                    '09001' => '弱加密算法风险检测',
                                    '09002' => '不安全的密钥长度风险检测',
                                    '09003' => 'ECB弱加密模式风险检测',
                                    '09004' => 'IVParameterSpec不安全初始化向量风险检测',
                                    '09005' => 'RSA中不使用Padding风险检测',
                                    '09006' => '检测keystore是否使用密码保护',
                                    '10001' => '敏感信息检测',
                                    '10002' => '剪贴板敏感信息泄露风险检测',
                                    '10003' => 'Intent敏感数据泄露风险检测',
                                    '10004' => 'PendingIntent误用风险',
                                    '10005' => '密钥硬编码风险检测',
                                    '10006' => '数据或程序加载检查',
                                    '10007' => 'BASE64安全检测',
                                    '10008' => '文件全局读写漏洞检测',
                                    '10009' => '日志泄露风险检测',
                                    '10010' => '外部加载Dex检测',
                                    '10011' => '外部存储路径检测',
                                    '10012' => '明文数字证书风险',
                                    '11001' => '安全相关的函数检测',
                                    '11002' => '安全相关的类检测',
                                    '11003' => '运行命令检测',
                                    '11004' => 'Native Library加载检测',
                                    '11005' => '外部动态加载DEX检测',
                                    '11006' => 'root代码检测',
                                    '11007' => '获取IMEI和Device ID敏感信息代码检测',
                                    '11008' => '获取Android ID敏感信息代码检测',
                                    '11009' => '发送SMS敏感代码检测',
                                    '11010' => '文件删除代码检测',
                                    '11011' => 'signature代码检测',
                                    '12001' => 'fragment注入漏洞检测',
                                    '12002' => 'sqlite数据库日志泄露漏洞检测',
                                    '12003' => '随机数生成漏洞检测'
                                );
                                for($i = 0; $i < $report_data['unsafe_items_num']; $i ++) {
                                    $identity = $report_data['unsafe_items'][$i]['identity'];
                                    $level = $report_data['unsafe_items'][$i]['level'];
                                    $result = $report_data['unsafe_items'][$i]['result'];
                                    $num = $report_data['unsafe_items'][$i]['num'];
                                    //使用正则匹配，将尖括号、换行和空格替换为成HTML能识别的格式
                                    $result = preg_replace('/</', '&lt', $result);
                                    $result = preg_replace('/>/', '&gt', $result);
                                    $result = preg_replace('/\n/', '<br/>', $result);
                                    $result = preg_replace('/ /', '&nbsp', $result);
                                    $title = $title_map[$identity];
                                    $description = $description_map[$identity];
                                    $advice = $advice_map[$identity];
                                    echo '<tr><td>';
                                    switch ($level) {
                                        case -2:
                                            echo '<span class="label label-success">展示</span>';
                                            break; 
                                        case 0:
                                            echo '<span class="label label-primary">提醒</span>';
                                            break;
                                        case 1:
                                            echo '<span class="label label-info">低危</span>';
                                            break;
                                        case 2:
                                            echo '<span class="label label-warning">中危</span>';
                                            break;
                                        case 3:
                                            echo '<span class="label label-danger">高危</span>';
                                            break;
                                        default:
                                            echo '<span class="label label-danger">error</span>';
                                            break;
                                    }
                                    echo <<<UNSAFE_ITEM_1
                                        </td>
                                        <td>
                                            <div class="bs">
                                                <p>
                                                    <a role="button" data-toggle="collapse" href="#$identity" aria-expanded="true" aria-controls="collapseExample">
                                                        $title                             
                                                    </a>
                                                </p>
                                                <div class="collapse" id="$identity">                                             
                                                    <div class="mb-10">
                                                        <p>风险描述<p>
                                                        <p>$description<p>
                                                    </div>
                                                    <div class="mb-10">
                                                        <p>风险详情</p>
UNSAFE_ITEM_1;
                                                        switch ($identity) {
                                                            case '04008':
                                                                echo "<p>该应用所支持的最低的版本的Android，存在[$num]个需要注意漏洞</p>";
                                                                break;
                                                            case '07001':
                                                                echo "<p>发现[$num]个匹配项</p>";
                                                                break;
                                                            case '07002':
                                                                echo "<p>发现[$num]个匹配项</p>";
                                                                break;
                                                            case '10001':
                                                                echo "<p>发现[$num]个敏感信息</p>";
                                                                break;
                                                            case '10002':
                                                                echo "<p>发现[$num]处存在剪贴板有保存信息</p>";
                                                                break;
                                                            case '10007':
                                                                echo "<p>发现有[$num]个BASE64字符串，并尝试解码</p>";
                                                                break;
                                                            case '11001':
                                                                echo "<p>发现有[$num]个与安全相关的函数</p>";
                                                                break;
                                                            case '11002':
                                                                echo "<p>发现有[$num]个与安全相关的类</p>";
                                                                break;
                                                            default:
                                                                echo "<p>共检测出[$num]项问题</p>";
                                                                break;
                                                        }
                                                        
                                                        echo <<<UNSAFE_ITEM_2
                                                        <code>$result</code>
                                                    </div>
                                                    <div>
                                                        <p>建议</p>
                                                        <p>$advice</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
UNSAFE_ITEM_2;
                                }

                            ?>
                            
                        </tbody>
                    </table>
                </div>
                <br>
            </div>
        </div>
            

        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="dist/js-custom/jquery.form.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="dist/js/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="vendors/bower_components/morris.js/morris.min.js"></script>
    <script src="dist/js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>


</body>
</html>