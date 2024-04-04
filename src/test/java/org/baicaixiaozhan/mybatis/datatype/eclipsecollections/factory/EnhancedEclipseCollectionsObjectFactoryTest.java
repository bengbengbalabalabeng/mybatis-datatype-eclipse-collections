package org.baicaixiaozhan.mybatis.datatype.eclipsecollections.factory;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.*;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.*;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.*;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import org.apache.ibatis.reflection.ReflectionException;

/**
 * DESC: Modify based on <a href="https://github.com/mybatis/mybatis-3/blob/master/src/test/java/org/apache/ibatis/reflection/factory/DefaultObjectFactoryTest.java">DefaultObjectFactoryTest.class</a>.
 *
 * @author baicaixiaozhan
 * @since v1.0.0
 */
class EnhancedEclipseCollectionsObjectFactoryTest {

    EnhancedEclipseCollectionsObjectFactory objectFactory;

    @BeforeEach
    void setUp() {
        objectFactory = new EnhancedEclipseCollectionsObjectFactory();
    }

    @Test
    void createClass() {
        TestClass testClass = objectFactory.create(TestClass.class, Arrays.asList(String.class, Integer.class),
                Arrays.asList("foo", 0));

        Assertions.assertEquals((Integer) 0, testClass.myInteger, "myInteger didn't match expected");
        Assertions.assertEquals("foo", testClass.myString, "myString didn't match expected");
    }

    @Test
    void createClassThrowsProperErrorMsg() {
        try {
            objectFactory.create(TestClass.class, Collections.singletonList(String.class), Collections.singletonList("foo"));
            Assertions.fail("Should have thrown ReflectionException");
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof ReflectionException, "Should be ReflectionException");
            Assertions.assertTrue(e.getMessage().contains("(String)"), "Should not have trailing commas in types list");
            Assertions.assertTrue(e.getMessage().contains("(foo)"), "Should not have trailing commas in values list");
        }
    }

    @Test
    void createHashMap() {
        Map map = objectFactory.create(Map.class, null, null);
        Assertions.assertTrue(map instanceof HashMap, "Should be HashMap");
    }

    @Test
    void createArrayList() {
        List list = objectFactory.create(List.class);
        Assertions.assertTrue(list instanceof ArrayList, " list should be ArrayList");

        Collection collection = objectFactory.create(Collection.class);
        Assertions.assertTrue(collection instanceof ArrayList, " collection should be ArrayList");

        Iterable iterable = objectFactory.create(Iterable.class);
        Assertions.assertTrue(iterable instanceof ArrayList, " iterable should be ArrayList");
    }

    @Test
    void createTreeSet() {
        SortedSet sortedSet = objectFactory.create(SortedSet.class);
        Assertions.assertTrue(sortedSet instanceof TreeSet, " sortedSet should be TreeSet");
    }

    @Test
    void createHashSet() {
        Set set = objectFactory.create(Set.class);
        Assertions.assertTrue(set instanceof HashSet, " set should be HashSet");
    }

    @Test
    void createMutableList() {
        MutableList list = objectFactory.create(MutableList.class);
        Assertions.assertTrue(list instanceof MutableList, " list should be MutableList");
    }

    @Test
    void createMutableSet() {
        MutableSet set = objectFactory.create(MutableSet.class);
        Assertions.assertTrue(set instanceof MutableSet, " set should be MutableSet");
    }

    @Test
    void createMutableSortSet() {
        MutableSortedSet set = objectFactory.create(MutableSortedSet.class);
        Assertions.assertTrue(set instanceof MutableSortedSet, " set should be MutableSortedSet");
    }

    @Test
    void createMutableBag() {
        MutableBag bag = objectFactory.create(MutableBag.class);
        Assertions.assertTrue(bag instanceof MutableBag, " bag should be MutableBag");
    }

    @Test
    void createMutableSortedBag() {
        MutableSortedBag bag = objectFactory.create(MutableSortedBag.class);
        Assertions.assertTrue(bag instanceof MutableSortedBag, " bag should be MutableSortedBag");
    }

    @Test
    void createMutableMap() {
        MutableMap map = objectFactory.create(MutableMap.class, null, null);
        Assertions.assertTrue(map instanceof MutableMap, "Should be MutableMap");
    }

    @Test
    void createMutableSortedMap() {
        MutableSortedMap map = objectFactory.create(MutableSortedMap.class, null, null);
        Assertions.assertTrue(map instanceof MutableSortedMap, "Should be MutableSortedMap");
    }

    @Test
    void createMutableBooleanCollection() {
        MutableBooleanList list = objectFactory.create(MutableBooleanList.class);
        Assertions.assertTrue(list instanceof MutableBooleanList, " list should be MutableBooleanList");

        MutableBooleanSet set = objectFactory.create(MutableBooleanSet.class);
        Assertions.assertTrue(set instanceof MutableBooleanSet, " set should be MutableBooleanSet");

        MutableBooleanBag bag = objectFactory.create(MutableBooleanBag.class);
        Assertions.assertTrue(bag instanceof MutableBooleanBag, " bag should be MutableBooleanBag");
    }

    @Test
    void createMutableByteCollection() {
        MutableByteList list = objectFactory.create(MutableByteList.class);
        Assertions.assertTrue(list instanceof MutableByteList, " list should be MutableByteList");

        MutableByteSet set = objectFactory.create(MutableByteSet.class);
        Assertions.assertTrue(set instanceof MutableByteSet, " set should be MutableByteSet");

        MutableByteBag bag = objectFactory.create(MutableByteBag.class);
        Assertions.assertTrue(bag instanceof MutableByteBag, " bag should be MutableByteBag");
    }

    @Test
    void createMutableCharCollection() {
        MutableCharList list = objectFactory.create(MutableCharList.class);
        Assertions.assertTrue(list instanceof MutableCharList, " list should be MutableCharList");

        MutableCharSet set = objectFactory.create(MutableCharSet.class);
        Assertions.assertTrue(set instanceof MutableCharSet, " set should be MutableCharSet");

        MutableCharBag bag = objectFactory.create(MutableCharBag.class);
        Assertions.assertTrue(bag instanceof MutableCharBag, " bag should be MutableCharBag");
    }

    @Test
    void createMutableDoubleCollection() {
        MutableDoubleList list = objectFactory.create(MutableDoubleList.class);
        Assertions.assertTrue(list instanceof MutableDoubleList, " list should be MutableDoubleList");

        MutableDoubleSet set = objectFactory.create(MutableDoubleSet.class);
        Assertions.assertTrue(set instanceof MutableDoubleSet, " set should be MutableDoubleSet");

        MutableDoubleBag bag = objectFactory.create(MutableDoubleBag.class);
        Assertions.assertTrue(bag instanceof MutableDoubleBag, " bag should be MutableDoubleBag");
    }

    @Test
    void createMutableFloatCollection() {
        MutableFloatList list = objectFactory.create(MutableFloatList.class);
        Assertions.assertTrue(list instanceof MutableFloatList, " list should be MutableFloatList");

        MutableFloatSet set = objectFactory.create(MutableFloatSet.class);
        Assertions.assertTrue(set instanceof MutableFloatSet, " set should be MutableFloatSet");

        MutableFloatBag bag = objectFactory.create(MutableFloatBag.class);
        Assertions.assertTrue(bag instanceof MutableFloatBag, " bag should be MutableFloatBag");
    }

    @Test
    void createMutableIntCollection() {
        MutableIntList list = objectFactory.create(MutableIntList.class);
        Assertions.assertTrue(list instanceof MutableIntList, " list should be MutableIntList");

        MutableIntSet set = objectFactory.create(MutableIntSet.class);
        Assertions.assertTrue(set instanceof MutableIntSet, " set should be MutableIntSet");

        MutableIntBag bag = objectFactory.create(MutableIntBag.class);
        Assertions.assertTrue(bag instanceof MutableIntBag, " bag should be MutableIntBag");
    }

    @Test
    void createMutableLongCollection() {
        MutableLongList list = objectFactory.create(MutableLongList.class);
        Assertions.assertTrue(list instanceof MutableLongList, " list should be MutableLongList");

        MutableLongSet set = objectFactory.create(MutableLongSet.class);
        Assertions.assertTrue(set instanceof MutableLongSet, " set should be MutableLongSet");

        MutableLongBag bag = objectFactory.create(MutableLongBag.class);
        Assertions.assertTrue(bag instanceof MutableLongBag, " bag should be MutableLongBag");
    }


    @Test
    void createMutableShortCollection() {
        MutableShortList list = objectFactory.create(MutableShortList.class);
        Assertions.assertTrue(list instanceof MutableShortList, " list should be MutableShortList");

        MutableShortSet set = objectFactory.create(MutableShortSet.class);
        Assertions.assertTrue(set instanceof MutableShortSet, " set should be MutableShortSet");

        MutableShortBag bag = objectFactory.create(MutableShortBag.class);
        Assertions.assertTrue(bag instanceof MutableShortBag, " bag should be MutableShortBag");
    }
}