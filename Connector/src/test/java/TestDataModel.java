import lombok.Data;

import java.util.List;

@Data
public class TestDataModel {

    private String data;

    private long userId;

    private int sessionId;

    private List<String> toList;

}
