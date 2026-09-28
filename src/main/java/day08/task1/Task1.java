package day08.task1;

public class Task1 {
    public static class InvalidScoreException extends RuntimeException{
        InvalidScoreException(String message) {
            super(message);
        }
        InvalidScoreException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ScoreParser {
        public int parse(String rawScore) {
            if (rawScore == null || rawScore.isBlank())
                throw new InvalidScoreException("Score can't be null or blank");

            int result;

            try {
                result = Integer.parseInt(rawScore.trim());
            } catch (NumberFormatException e) {
                throw new InvalidScoreException("Score must be an integer", e);
            }
            if (result < 0 || result > 100)
                throw new InvalidScoreException("Score must be between 0 and 100 inclusive");
            return result;
        }
    }

    public static void main(String[] args) {
        ScoreParser scoreParser = new ScoreParser();
        try {
            System.out.println(scoreParser.parse("85"));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(scoreParser.parse(" 70 "));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(scoreParser.parse("abc"));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(scoreParser.parse("-1"));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(scoreParser.parse("101"));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(scoreParser.parse(null));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(scoreParser.parse(" "));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
