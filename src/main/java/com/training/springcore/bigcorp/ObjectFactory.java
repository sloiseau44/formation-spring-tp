package com.training.springcore.bigcorp;

import com.training.springcore.service.*;

public class ObjectFactory {
    public static SiteService createSiteService() {
        return new SiteServiceImpl(createCaptorService());
    }

    public static CaptorService createCaptorService() {
        return new CaptorServiceImpl();
    }

}
