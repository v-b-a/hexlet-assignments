package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    String errorCode;
//    String message;



    public NegativeRadiusException(String errorCode) {
        this.errorCode = errorCode;
//        this.message = message;
    }

}
// END
