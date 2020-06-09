<?php

    $database = new Database($ADDRESS, $USER, $PASSWORD, $DATABASE);
    //$mysqli = $database -> connect();

    $res = $database -> get_data_from_verify($email);

    $state_message = $res['state_code'];

    //$database -> close($mysqli);
    class Database {
        var $mysqli;

        function Database($ADDRESS, $USER, $PASSWORD, $DATABASE) {
            $this -> mysqli = new mysqli($ADDRESS, $USER, $PASSWORD, $DATABASE);
            ($this -> mysqli) -> set_charset('utf8');
        }
/*
        function connect() {
            return new mysqli(ADDRESS, USER, PASSWORD, DATABASE);
        }

        function close($mysqli) {
            $mysqli -> close();
        }
*/
        function get_data_from_table_verify($email) {
            $state_message = 0;
            $stmt = $mysqli -> prepare("select * from verify where email = ?");
            $stmt -> bind_param('s', $email);
            if($stmt -> execute()) {
                $res = $stmt -> get_result();
                $num_rows = $res -> num_rows;
                $row = $res -> fetch_array(MYSQLI_ASSOC);
            } else {
                $state_message = 404;
            }

            return array('state_message' => $state_message, 'row' => $row, 'num_rows' => $num_rows);
        }

        function delete_data_from_table_verify($email) {

        }

        function get_data_from_table_user($email) {

        }


        function get_data_from_table_report($apk_name) {

        }

        function update_data_in_table_user($token_key, $token_key_end, $email) {

        }

        //apk
        function get_data_from_table_apk($user_id) {

        }

        function update_data_in_table_apk($token_key, $token_key_end, $email) {

        }

        function delete_data_in_table_apk($token_key, $token_key_end, $email) {

        }

    }

?>