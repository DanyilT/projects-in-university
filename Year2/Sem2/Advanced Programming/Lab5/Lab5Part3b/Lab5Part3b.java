package Lab5Part3b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab5Part3b {
    public static void main(String[] args) {
        String randomString = "Tymchuk! Oh wait, who is it? Danyil, is it you? Can I ask you a question please..? They'll not gonna believe that I met Danyil Tymchuk. Did anyone told you that you are the amazing man, Danyil, right? You are truly best a Danyil, probably.. I think so, just assuming that any other Danyils is worst, because I don't know any other one like you Danyil. Yeah... What I was talking about? Oh, right, Danyil Tymchuk!? Just a clarifying question, are you the Batman Mr. Tymchuk? Ok, you don't want to answer, hmm.. that's suspicious... Ok nevermind. I just wondering, that I never saw Danyil Tymchuk and Batman in the same room. That's interesting, right?";

        String regex = "Danyil|Tymchuk";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(randomString);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group() + " at index " + matcher.start());
        }
    }
}
