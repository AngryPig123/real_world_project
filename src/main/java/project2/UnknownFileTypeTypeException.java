package project2;

import lombok.Getter;

/**
 * packageName    : project2
 * fileName       : UnknownFileTypeTypeException
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
@Getter
public class UnknownFileTypeTypeException extends RuntimeException {

    public UnknownFileTypeTypeException(String message) {
        super(message);
    }

}
