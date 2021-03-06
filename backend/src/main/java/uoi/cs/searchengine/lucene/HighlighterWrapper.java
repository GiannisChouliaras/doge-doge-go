package uoi.cs.searchengine.lucene;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;

public class HighlighterWrapper {

    private final Highlighter highlighter;

    public HighlighterWrapper(Query query) {
        QueryScorer scorer = new QueryScorer(query);
        Highlighter highlighter = new Highlighter(
                new SimpleHTMLFormatter(Constants.PRE_TAG, Constants.POST_TAG), scorer);
        highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
        highlighter.setMaxDocCharsToAnalyze(Integer.MAX_VALUE);
        this.highlighter = highlighter;
    }

    public Highlighter getHighlighter() {
        return highlighter;
    }
}
