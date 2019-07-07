package edu.stanford.nlp.pipeline;

import java.util.Properties;

public class TokenizerSpanishBenchmarkITest extends TokenizerBenchmarkTestCase {

    @Override
    public void setUp() {
        // set up the pipeline
        Properties props = new Properties();
        props.put("annotators", "tokenize,ssplit,mwt");
        props.put("tokenize.language", "es");
        props.put("tokenize.options", "splitAll=false");
        props.put("mwt.mappingFile",
                  "/u/nlp/data/stanford-corenlp/test/data/mwt/es-mwt.tsv");
        pipeline = new StanfordCoreNLP(props);
    }

    public void testOnDev() {
        goldFilePath = "/u/nlp/data/stanford-corenlp/test/data/tokenize/es_ancora-ud-dev.conllu";
        runTest("dev", "es", 0.994);
    }

}