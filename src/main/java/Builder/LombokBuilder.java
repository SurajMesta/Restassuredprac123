package Builder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)

public class LombokBuilder {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
