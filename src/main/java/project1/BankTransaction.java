package project1;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * packageName    : project1
 * fileName       : BankTransaction
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
@Getter
public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

    private BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public static BankTransaction from(LocalDate date, double amount, String description) {
        return new BankTransaction(date, amount, description);
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        BankTransaction that = (BankTransaction) object;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(date, that.date) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(date);
        result = 31 * result + Double.hashCode(amount);
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

}


