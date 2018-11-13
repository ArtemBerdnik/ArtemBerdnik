package api.enums;

public enum SoapActions {
        CHECK_TEXT("checkText", "CheckTextRequest"),
        CHECK_TEXTS("checkTexts", "CheckTextsRequest");
        private String method;
        private String reqName;

    public String getMethod() {
        return method;
    }

    public String getReqName() {
        return reqName;
    }

    SoapActions(String action, String reqName) {
            this.method = action;
            this.reqName = reqName;
        }
    }

