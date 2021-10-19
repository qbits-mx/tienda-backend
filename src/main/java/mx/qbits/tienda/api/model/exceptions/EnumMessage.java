package mx.qbits.tienda.api.model.exceptions;

public enum EnumMessage {
    USER_NOT_EXIST_ES(
            1001,
            "El usuario %s no existe", 
            "No ha sido posible encontrar al usuario %s en la base de datos",
            HttpStatus.BAD_REQUEST),
    
    USER_NOT_EXIST_EN(
            1001,
            "The user %s does not exist", 
            "It was not possible to find usr %s in the database",
            HttpStatus.ACCEPTED),
    
    UPLOAD_ES(
            1002, 
            "corto",
            "largo", 
            HttpStatus.ACCEPTED),
    
    UPLOAD_EN(
            1002, 
            "corto",
            "largo", 
            HttpStatus.ACCEPTED);
    
    
    
    
    
    
/** ************************************************************ **/
/** ************************************************************ **/
/** ************************************************************ **/
/** ************************************************************ **/
    
    private int exceptionNumber;
    private String shortMessage;
    private String detailedMessage;
    private HttpStatus httpStatus;
    
    EnumMessage(
            int exceptionNumber, 
            String shortMessage, 
            String detailedMessage, 
            HttpStatus httpStatus) {
        this.exceptionNumber = exceptionNumber;
        this.shortMessage = shortMessage;
        this.detailedMessage = detailedMessage;
        this.httpStatus = httpStatus;
    }
    
    public int getExceptionNumber() {
        return this.exceptionNumber;
    }
    public String getShortMessage() {
        return this.shortMessage;
    }
    public String getDetailedMessage() {
        return this.detailedMessage;
    }
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
