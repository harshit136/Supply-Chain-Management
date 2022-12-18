module com.example.supplychainmanagementsystembyharshit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supplychainmanagementsystembyharshit to javafx.fxml;
    exports com.example.supplychainmanagementsystembyharshit;
}