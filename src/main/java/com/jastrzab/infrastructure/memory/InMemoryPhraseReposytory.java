package com.jastrzab.infrastructure.memory;

import com.jastrzab.domain.port.PhraseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InMemoryPhraseReposytory implements PhraseRepository {

    private List<String> phrases = Arrays.asList( new String[]{"diplomat","undress","theme","handy","theory","reform","hiccup","objective","impact","release","rare","gravity","memorial","occupation","frog","perfect","sympathetic","cousin","work","smoke","surface","coffee","meal","leg","continuous","pick","pillow","zero","dough","impress","module","screen","folklore","advantage","ask","warning","encourage","unlike","inquiry","preach"});

    @Override
    public String getPhrase() {
        return this.phrases.get(new Random().nextInt(phrases.size()));
    }
}
