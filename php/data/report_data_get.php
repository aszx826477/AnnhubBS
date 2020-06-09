<?php

    include "../conf.php";
    include "../annhub_func.php";

    $state_message = check_cookie();
    if($state_message == 0) {
        $email = explode(' ', $_COOKIE["Annhub"])[0];
        $btn_code = $_POST['btn_code'];

        //根据用户点击的按钮，确定APK的名称
        $message = ensure_apk_name($btn_code);
        $state_message = $message[0];
        if($state_message != 0) {
            return json_encode(array('state_message' => $state_message));
        }
        $apk_name = $message[1];

        $mysqli = new mysqli($MYSQL_ADDRESS, $MYSQL_USER, $MYSQL_PASSWORD, $MYSQL_DATABASE);
        $mysqli -> set_charset('utf8');
        
        if(!$mysqli -> connect_error) {
            $stmt = $mysqli -> prepare("select apk_id, apk_real_name, upload_date, high, middle, low, warning, total, score, level from apk where apk_name = ?");
            $stmt -> bind_param('s', $apk_name);
            $stmt -> execute();
            $res = $stmt -> get_result();
            $stmt -> close();
            $row = $res -> fetch_array(MYSQLI_ASSOC);
            $apk_id = $row['apk_id'];

           

            //统计所有非安全扫描项的数量，并存储到一个结果集中
            $stmt_1 = $mysqli -> prepare("select identity, result, level, num from report where apk_id = ? and level != -1");
            $stmt_1 -> bind_param('i', $apk_id);
            $stmt_1 -> execute();
            $res_1 = $stmt_1 -> get_result();
            $unsafe_items_num = $res_1 -> num_rows;
            $stmt_1 -> close();
            for($i = 0; $i < $unsafe_items_num; $i ++) {
                $row_1 = $res_1 -> fetch_array(MYSQLI_ASSOC);
                $unsafe_items[$i] = array(
                    'identity' => $row_1['identity'],
                    'level' => $row_1['level'],
                    'result' => $row_1['result'],
                    'num' => $row_1['num']
                );
            }
            
            //筛选特定的扫描项
            $stmt_item = $mysqli -> prepare("select result, level from report where apk_id = ? and identity = ?");

            $file_size = get_item_data_by_identify($stmt_item, $apk_id, '01002')['result'];
            $file_md5 = get_item_data_by_identify($stmt_item, $apk_id, '01003')['result'];
            $package = get_item_data_by_identify($stmt_item, $apk_id, '01004')['result'];
            $main_activity = get_item_data_by_identify($stmt_item, $apk_id, '01005')['result'];
            $min_sdk = get_item_data_by_identify($stmt_item, $apk_id, '01006')['result'];
            $target_sdk = get_item_data_by_identify($stmt_item, $apk_id, '01007')['result'];

            $permission = get_item_data_by_identify($stmt_item, $apk_id, '02001')['result'];

            $activity = get_item_data_by_identify($stmt_item, $apk_id, '03001')['result'];
            $service = get_item_data_by_identify($stmt_item, $apk_id, '03002')['result'];
            $receiver = get_item_data_by_identify($stmt_item, $apk_id, '03003')['result'];
            $provider = get_item_data_by_identify($stmt_item, $apk_id, '03004')['result'];
            
            $stmt_item -> close();

            $data = array(
                'apk_real_name' => $row['apk_real_name'],
                'level' => $row['level'],
                'score' => $row['score'],
                'date' => $row['upload_date'],
                'high' => $row['high'],
                'middle' => $row['middle'],
                'low' => $row['low'],
                'warning' => $row['warning'],
                'file_size' => $file_size,
                'file_md5' => $file_md5,
                'package' => $package,
                'main_activity' => $main_activity,
                'min_sdk' => $min_sdk,
                'target_sdk' => $target_sdk,
                'permission' => $permission,
                'activity' => $activity,
                'service' => $service,
                'receiver' => $receiver,
                'provider' => $provider,      
                'unsafe_items_num' => $unsafe_items_num,
                'unsafe_items' => $unsafe_items
                
            );

            
        } else {

            $state_message = 401; //数据库连接失败
        }

        $mysqli -> close();
    }

    if($state_message == 0) {
        $return = array('state_message' => $state_message, 'data' => $data);
    } else {
        $return = array('state_message' => $state_message, 'data' => null);
    }

    echo json_encode($return);


    function get_item_data_by_identify($stmt_item, $apk_id, $identity) {
        $stmt_item -> bind_param('is', $apk_id, $identity);
        $stmt_item -> execute();
        $res_item = $stmt_item -> get_result();
        $row_item = $res_item -> fetch_array(MYSQLI_ASSOC);
        $level = $row_item['level'];
        $result = $row_item['result'];
        return array('level' => $level, 'result' => $result);
    }

?>