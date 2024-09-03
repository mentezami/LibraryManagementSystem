////package com.librarymanagement.libmngsystem.config;
////
////import org.springframework.cache.annotation.EnableCaching;
////import org.springframework.cache.CacheManager;
////import org.springframework.cache.jcache.JCacheCacheManager;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.core.io.ClassPathResource;
////import javax.cache.Caching;
////import javax.cache.spi.CachingProvider;
////import java.io.IOException;
////
////@Configuration
////@EnableCaching
////public class CacheConfig {
////
////    @Bean
////    public CacheManager cacheManager() throws IOException {
////        CachingProvider cachingProvider = Caching.getCachingProvider();
////
////        javax.cache.CacheManager jCacheManager = cachingProvider.getCacheManager(
////                new ClassPathResource("ehcache.xml").getURI(),
////                getClass().getClassLoader()
////        );
////
////        return new JCacheCacheManager(jCacheManager);
////    }
////}
//
//package com.librarymanagement.libmngsystem.config;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.jcache.JCacheCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.cache.Caching;
//import javax.cache.spi.CachingProvider;
////import javax.cache.CacheManager; //as JCacheManager;
//import java.io.IOException;
//
//@Configuration
//@EnableCaching
//public class CacheConfig {
//
//    @Bean
//    public CacheManager cacheManager() throws IOException {
//        CachingProvider cachingProvider = Caching.getCachingProvider();
//
//        // Load the Ehcache configuration from classpath
//        ClassPathResource resource = new ClassPathResource("ehcache.xml");
//        javax.cache.CacheManager jCacheManager = cachingProvider.getCacheManager(
//                resource.getURI(),
//                getClass().getClassLoader()
//        );
//
//        return new JCacheCacheManager(jCacheManager);
//    }
//}
