package LogWindow.UI;

public enum Scenes {
    MAIN{
        @Override
        public String toString() {
            return "/loginWindow.fxml";
        }
    },
    SUCCESS{
        @Override
        public String toString() {
            return "/success.fxml";
        }
    },
    FAIL{
        @Override
        public String toString() {
            return "/fail.fxml";
        }
    }
}
