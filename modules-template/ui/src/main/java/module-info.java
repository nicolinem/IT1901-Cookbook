module calc.ui {
  requires calc.core;
  requires javafx.controls;
  requires javafx.fxml;
  requires json.simple;
  exports ui;

  opens ui to javafx.graphics, javafx.fxml;
}
