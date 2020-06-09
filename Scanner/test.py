import scanner
import constant
import statistic


#file_name = '6dbb160cd0a97cd00f8837940728513fd0bc4b50f99721381091e478af51b563-1541469613-123.apk'
file_name = '6dbb160cd0a97cd00f8837940728513fd0bc4b50f99721381091e478af51b563-1541469613-124.apk'
src_path = constant.APK_SOURCES_DIR + file_name
#file_md5 = 'b8ecbafac716977edec83d44b2c8d589'
file_md5 = '9f16673f77e9fdaa1d5960ffab2a5732'
dst_path = constant.OUTCOMES_DIR + file_md5 + '/'
scanner.do_static_scan(src_path, dst_path)
statistic.data_analyse(src_path)
