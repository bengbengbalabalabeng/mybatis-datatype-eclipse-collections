# MyBatis datatype for EclipseCollections API

The MyBatis data type supporting types introduced in EclipseCollections API.

[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

## Installation

**The current project is not published to the central repository, please pack it yourself if you need to use it.**
Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.baicaixiaozhan</groupId>
    <artifactId>mybatis-datatype-eclipse-collections</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Configuration

If you are using MyBatis 3.5 or later in Spring Boot, you can simply add this:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public MyBatisConfig {
    
    @Bean 
    public ConfigurationCustomizer customizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setObjectFactory(new EnhancedEclipseCollectionsObjectFactory());
            }
        };
    }
}
```

If you not use Spring Boot, you can add the object factory to your `mybatis-config.xml` as follow:

```xml
<objectFactory type="org.baicaixiaozhan.mybatis.datatype.eclipsecollections.factory.EnhancedEclipseCollectionsObjectFactory" />
```
We recommended that you use Java 11 or later.

## Supported types

The following data type are supported:

- `MutableList`
- `MutableSet`
- `MutableSortedSet`
- `MutableBag`
- `MutableSortedBag`
- `MutableMap`
- `MutableSortedMap`
- `MutableBooleanList`
- `MutableBooleanSet`
- `MutableBooleanBag`
- `MutableByteList`
- `MutableByteSet`
- `MutableByteBag`
- `MutableCharList`
- `MutableCharSet`
- `MutableCharBag`
- `MutableDoubleList`
- `MutableDoubleSet`
- `MutableDoubleBag`
- `MutableFloatList`
- `MutableFloatSet`
- `MutableFloatBag`
- `MutableIntList`
- `MutableIntSet`
- `MutableIntBag`
- `MutableLongList`
- `MutableLongSet`
- `MutableLongBag`
- `MutableShortList`
- `MutableShortSet`
- `MutableShortBag`

## How to Contribute

We welcome contributions! We accept contributions via pull requests here 😊.

## Links

- MyBatis: https://mybatis.org/mybatis-3/
- **Eclipse** Collections: https://eclipse.dev/collections/