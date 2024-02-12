package bean_entity;
import jakarta.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class EmprunteurNotFound extends Exception {}


