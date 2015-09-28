<?php
 
// array for JSON response
$response = array();
 
// include db connect class
//require_once 'db_connect.php';
 
// connecting to db
//$db = new db_connect();
$con = mysql_connect("localhost", "trikarya_1", "trikarya1");
// selecting database
mysql_select_db("trikarya_hotelku"); 

if (isset($_POST['turis_nama']) && isset($_POST['turis_tgl_lahir']) 
    && isset($_POST['turis_kelamin']) && isset($_POST['turis_status'])
    && isset($_POST['turis_telp']) && isset($_POST['turis_email'])
    && isset($_POST['turis_password']) && isset($_POST['turis_foto'])) {
 
    $turis_nama = $_POST['turis_nama'];
    $turis_tgl_lahir = $_POST['turis_tgl_lahir'];
    $turis_kelamin = $_POST['turis_kelamin'];
    $turis_status = $_POST['turis_status'];
    $turis_telp = $_POST['turis_telp'];
    $turis_email = $_POST['turis_email'];
    $turis_password = $_POST['turis_password'];
    //$turis_foto = $_POST['turis_foto'];
    $turis_verified = 0;
    
    //insert data turis
    $result = mysql_query("INSERT INTO trikarya_hotelku 
            (TURIS_ID, TURIS_NAMA, TURIS_TGL_LAHIR, JENIS_KELAMIN_ID, STATUS_PERNIKAHAN_ID, TURIS_NO_TELP,
                TURIS_EMAIL, TURIS_PASSWORD, TURIS_FOTO, TURIS_VERIFIED) 
            VALUES ('$turis_nama','$turis_tgl_lahir','$turis_kelamin','$turis_status',
                '$turis_telp','$turis_email','$turis_password','$turis_verified')") or die(mysql_error());
    //foto turis how??????? 

    // check if row inserted or not
    if ($result) {
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "Simpan data turis berhasil";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
 
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>