public class QuestionCandidate {
    private Question question;
    private Candidate candidate;
    private AnswerAlternative answerAlternative;

    public QuestionCandidate() {
    }

    public QuestionCandidate(Question question, Candidate candidate, AnswerAlternative answerAlternative) {
        this.question = question;
        this.candidate = candidate;
        this.answerAlternative = answerAlternative;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public AnswerAlternative getAnswerAlternative() {
        return answerAlternative;
    }

    public void setAnswerAlternative(AnswerAlternative answerAlternative) {
        this.answerAlternative = answerAlternative;
    }
}