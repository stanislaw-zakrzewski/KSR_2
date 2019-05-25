package summarization_sentences;

import helpers.DelayFunction;

public class SentenceTest {
    public static void main(String[] args) {
        Q q = new Q("mało", 0.3f);
        P p = new P("origin_state_name", "New York");
        S s = new S("dep_delay", "bardzo spóźnione", new DelayFunction());
        SimpleSentence simpleSentence = new SimpleSentence(q,p,s);
        simpleSentence.CalculateValues();
        System.out.println(q.getValue() + " lotów do " + p.getValue() + " było " + s.getSelectedWord() + ".     [" + simpleSentence.finalValue() + "]");
    }
}
