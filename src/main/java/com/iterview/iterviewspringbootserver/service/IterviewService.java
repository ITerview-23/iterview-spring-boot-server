package com.iterview.iterviewspringbootserver.service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IterviewService {

    public ArrayList<String> parse(String input) {
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        input = input.replace('\n',' ').replace('\t',' ').replace('\r',' ');
        KomoranResult result;
        try {
            result = komoran.analyze(input);
        }catch (NullPointerException e){
            System.out.println(input);
            return null;
        }
        if(result == null) return null;
        List<Token> tokenList;
        try {
            tokenList = result.getTokenList();
        }catch (NullPointerException e){
            System.out.println(input);
            return null;
        }
        Set<String> NNList = new HashSet<>();
        for (Token token : tokenList) {
            if(token.getPos().contains("NN"))
                NNList.add(token.getMorph());
        }
        ArrayList<String> NNList2 = new ArrayList<>(NNList);
        return NNList2;
    }
}
