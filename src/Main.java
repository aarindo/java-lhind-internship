import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Survey> surveys = new ArrayList<>();
        List<Candidate> candidates = new ArrayList<>();
        List<QuestionCandidate> questionCandidates = new ArrayList<>();

        System.out.println("Welcome!");
        while (true) {
            System.out.println("Choose an number for an action: ");
            System.out.println("1. Create survey 2. Register candidate 3. Take Survey");
            System.out.println("4. Most given answer on a survey 5. Exit");

            Scanner myInput = new Scanner(System.in);
            int actionNr = myInput.nextInt();

            if (actionNr == 1) {
                var survey = createSurvey();
                var surveyFound = surveys
                        .stream()
                        .filter(el -> el.getTitle().equals(survey.getTitle()))
                        .findFirst();
                if (surveyFound.isPresent()) {
                    System.out.printf("Not saved. Survey with title %s already exists!%n", survey.getTitle());
                } else {
                    var surveyNew = survey;
                    surveys.add(surveyNew);
                    System.out.printf("Survey %s saved successfully.%n", surveyNew.getTitle());

                    int countQuestions = 0;
                    while (countQuestions <= 40) {
                        var question = createQuestion();
                        var questionFound = surveyNew
                                .getQuestions()
                                .stream()
                                .filter(el -> el.getTitle().equals(question.getTitle()))
                                .findFirst();
                        if (questionFound.isPresent()) {
                            System.out.printf("Question %s already exists on this survey.%n", question.getTitle());
                        } else {
                            question.setSurvey(surveyNew);
                            surveyNew.addQuestion(question);

                            countQuestions++;
                            if (countQuestions >= 10) {
                                System.out.println("Do you want to add another question? y/n");
                                String choice = myInput.next();
                                if (choice.equals("n") || choice.equals("N")) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (actionNr == 2) {
                var candidateNew = registerCandidate();
                var candidateFound = candidates.stream().filter(el -> el.getEmail().equals(candidateNew.getEmail())).findFirst();
                if (candidateFound.isPresent()) {
                    System.out.printf("Candidate with email %s already has been registered %n", candidateNew.getEmail());
                } else {
                    candidates.add(candidateNew);
                    System.out.printf("Candidate with email %s is registered successfully%n", candidateNew.getEmail());

                }
            }

            if (actionNr == 3) {
                if (surveys.isEmpty()) {
                    System.out.println("There are no surveys created.");
                } else if (candidates.isEmpty()) {
                    System.out.println("There are no candidates registered.");
                } else {
                    while (true) {
                        myInput.nextLine();
                        System.out.println("Survey title: ");
                        String title = myInput.nextLine();
                        var survey = surveys
                                .stream()
                                .filter(el -> el.getTitle()
                                        .equals(title))
                                .findFirst();
                        if (survey.isEmpty()) {
                            System.out.printf("Survey with title %s doesnt exists!%n", title);
                        } else {
                            System.out.println("Candidate email: ");
                            String email = myInput.nextLine();
                            var candidateFound = candidates.stream().filter(el -> el.getEmail().equals(email)).findFirst();
                             if (candidateFound.isEmpty()) {
                                System.out.printf("Candidate with email %s doesnt exists!%n", email);
                             } else {
                                survey.get().getQuestions().forEach(el -> {
                                    QuestionCandidate questionCandidate = new QuestionCandidate();
                                    questionCandidate.setQuestion(el);
                                    questionCandidate.setCandidate(candidateFound.get());

                                    System.out.println(el.getTitle());
                                    System.out.println("Do you: a)Agree b)Slightly agree c)Slightly disagree d)Disagree e)Other");
                                    String choice = myInput.next();
                                    switch (choice) {
                                        case "a", "A" ->
                                                questionCandidate.setAnswerAlternative(AnswerAlternative.AGREE);
                                        case "b", "B" ->
                                                questionCandidate.setAnswerAlternative(AnswerAlternative.SLIGHTLY_AGREE);
                                        case "c", "C" ->
                                                questionCandidate.setAnswerAlternative(AnswerAlternative.SLIGHTLY_DISAGREE);
                                        case "d", "D" ->
                                                questionCandidate.setAnswerAlternative(AnswerAlternative.DISAGREE);
                                        case "e", "E" -> questionCandidate.setAnswerAlternative(null);
                                    }
                                    questionCandidates.add(questionCandidate);
                                });
                                System.out.println("All answers were saved.");
                             }
                        }
                        break;
                    }
                }
            }

            if (actionNr == 4) {
                int[] countAnswers = checkAnswersPerSurvey(surveys, questionCandidates);
                if (countAnswers != null) {
                    int max = Arrays.stream(countAnswers).max().getAsInt();
                    if (max == 0) {
                        System.out.println("No candidate took this survey yet.");
                        break;
                    }
                    for(int i = 0; i < countAnswers.length; i++) {
                        if (countAnswers[i] == max && i == 0) {
                            System.out.printf("Most given answer is Agree with a count of %d%n", max);
                        } else if (countAnswers[i] == max && i == 1) {
                            System.out.printf("Most given answer is Slightly Agree with a count of %d%n", max);
                        } else if (countAnswers[i] == max && i == 2) {
                            System.out.printf("Most given answer is Slightly Disagree with a count of %d%n", max);
                        } else if (countAnswers[i] == max && i == 3) {
                            System.out.printf("Most given answer is Disagree with a count of %d%n", max);
                        } else if (countAnswers[i] == max && i == 4) {
                            System.out.printf("Most given answer is Other with a count of %d%n", max);
                        }
                    }
                }
            }

            if (actionNr == 5) {
                break;
            }
        }
    }

    public static Survey createSurvey() {
        Survey survey = new Survey();
        Scanner myInput = new Scanner(System.in);
        System.out.println("Unique title: ");
        String title = myInput.nextLine();
        survey.setTitle(title);
        System.out.println("Topic: ");
        String topic = myInput.nextLine();
        survey.setTopic(topic);
        System.out.println("Description: ");
        String desc = myInput.nextLine();
        survey.setDescription(desc);
        return survey;
    }

    public static Candidate registerCandidate() {
        Candidate candidate = new Candidate();
        Scanner myInput = new Scanner(System.in);
        System.out.println("First name: ");
        String fname = myInput.nextLine();
        candidate.setFirstName(fname);
        System.out.println("Last name: ");
        String lname = myInput.nextLine();
        candidate.setLastName(lname);
        System.out.println("Unique email: ");
        String email = myInput.nextLine();
        candidate.setEmail(email);
        System.out.println("Phone number: ");
        long phoneNr = myInput.nextLong();
        candidate.setPhoneNr(phoneNr);
        return candidate;
    }

    public static Question createQuestion() {
        Question question = new Question();
        Scanner myInput = new Scanner(System.in);
        System.out.println("Unique question title: ");
        String title = myInput.nextLine();
        question.setTitle(title);
        return question;
    }

    public static int[] checkAnswersPerSurvey(List<Survey> surveys, List<QuestionCandidate> questionCandidates) {
        System.out.println("Survey title: ");
        Scanner myInput = new Scanner(System.in);
        String title = myInput.nextLine();
        var surveyFound = surveys
                .stream()
                .filter(el -> el.getTitle().equals(title))
                .findFirst();
        if (surveyFound.isEmpty()) {
            System.out.printf("Survey with title %s doesnt exists!%n", title);
            return null;
        } else {
            int[] countAnswersInEnumOrderAndOther = {0,0,0,0,0};

            surveyFound.get().getQuestions().forEach(question -> {
                var questionCandidate = questionCandidates
                        .stream()
                        .filter(el -> el.getQuestion().equals(question))
                        .findFirst();

                if (questionCandidate.isPresent()) {
                    var answer = questionCandidate.get().getAnswerAlternative();
                    if (answer == null) {
                        countAnswersInEnumOrderAndOther[4]++;
                    } else if (answer.equals(AnswerAlternative.AGREE)) {
                        countAnswersInEnumOrderAndOther[0]++;
                    } else if (answer.equals(AnswerAlternative.SLIGHTLY_AGREE)) {
                        countAnswersInEnumOrderAndOther[1]++;
                    } else if (answer.equals(AnswerAlternative.SLIGHTLY_DISAGREE)) {
                        countAnswersInEnumOrderAndOther[2]++;
                    } else if (answer.equals(AnswerAlternative.DISAGREE)) {
                        countAnswersInEnumOrderAndOther[3]++;
                    }
                }
            });
            return countAnswersInEnumOrderAndOther;
        }
    }
}