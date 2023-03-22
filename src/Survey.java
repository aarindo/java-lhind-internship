import java.util.ArrayList;
import java.util.List;

public class Survey {
    private String title;
    private String topic;
    private String description;

    private List<Question> questions = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    public void setDescription(String description) {
        this.description = description;
    }
}