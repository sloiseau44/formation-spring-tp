package com.training.springcore.trash;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.inject.Named;

@Named("deezerFinder")
public class DeezerCatalog implements MusicFinder{
}
