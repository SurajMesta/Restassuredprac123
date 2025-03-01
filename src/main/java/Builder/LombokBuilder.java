package Builder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
@Getter
@Setter
@Builder(setterPrefix = "set",buildMethodName = "perform")

public class LombokBuilder {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
