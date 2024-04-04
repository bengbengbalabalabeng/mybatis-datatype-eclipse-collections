package org.baicaixiaozhan.mybatis.datatype.eclipsecollections.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.*;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.collection.primitive.*;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.*;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.*;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.*;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.*;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.*;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

/**
 * DESC: MyBatis uses an ObjectFactory to create all needed Eclipse Collections new Objects.
 *
 * @author baicaixiaozhan
 * @since v1.0.0
 */
public class EnhancedEclipseCollectionsObjectFactory extends DefaultObjectFactory {

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        // Mutable Collection
        if (MutableList.class.isAssignableFrom(type)) {
            return FastList.class;
        } else if (MutableSortedSet.class.isAssignableFrom(type)) {
            return TreeSortedSet.class;
        } else if (MutableSet.class.isAssignableFrom(type)) {
            return UnifiedSet.class;
        } else if (MutableSortedBag.class.isAssignableFrom(type)) {
            return TreeBag.class;
        } else if (MutableBag.class.isAssignableFrom(type)) {
            return HashBag.class;
        }

        // Mutable Map
        if (MutableSortedMap.class.isAssignableFrom(type)) {
            return TreeSortedMap.class;
        } else if (MutableMap.class.isAssignableFrom(type)) {
            return UnifiedMap.class;
        }

        // Mutable Primitive
        if (MutableBooleanCollection.class.isAssignableFrom(type)) {
            if (MutableBooleanList.class.isAssignableFrom(type)) {
                return BooleanArrayList.class;
            } else if (MutableBooleanSet.class.isAssignableFrom(type)) {
                return BooleanHashSet.class;
            } else if (MutableBooleanBag.class.isAssignableFrom(type)) {
                return BooleanHashBag.class;
            }
        } else if (MutableByteCollection.class.isAssignableFrom(type)) {
            if (MutableByteList.class.isAssignableFrom(type)) {
                return ByteArrayList.class;
            } else if (MutableByteSet.class.isAssignableFrom(type)) {
                return ByteHashSet.class;
            } else if (MutableByteBag.class.isAssignableFrom(type)) {
                return ByteHashBag.class;
            }
        } else if (MutableCharCollection.class.isAssignableFrom(type)) {
            if (MutableCharList.class.isAssignableFrom(type)) {
                return CharArrayList.class;
            } else if (MutableCharSet.class.isAssignableFrom(type)) {
                return CharHashSet.class;
            } else if (MutableCharBag.class.isAssignableFrom(type)) {
                return CharHashBag.class;
            }
        } else if (MutableDoubleCollection.class.isAssignableFrom(type)) {
            if (MutableDoubleList.class.isAssignableFrom(type)) {
                return DoubleArrayList.class;
            } else if (MutableDoubleSet.class.isAssignableFrom(type)) {
                return DoubleHashSet.class;
            } else if (MutableDoubleBag.class.isAssignableFrom(type)) {
                return DoubleHashBag.class;
            }
        } else if (MutableFloatCollection.class.isAssignableFrom(type)) {
            if (MutableFloatList.class.isAssignableFrom(type)) {
                return FloatArrayList.class;
            } else if (MutableFloatSet.class.isAssignableFrom(type)) {
                return FloatHashSet.class;
            } else if (MutableFloatBag.class.isAssignableFrom(type)) {
                return FloatHashBag.class;
            }
        } else if (MutableIntCollection.class.isAssignableFrom(type)) {
            if (MutableIntList.class.isAssignableFrom(type)) {
                return IntArrayList.class;
            } else if (MutableIntSet.class.isAssignableFrom(type)) {
                return IntHashSet.class;
            } else if (MutableIntBag.class.isAssignableFrom(type)) {
                return IntHashBag.class;
            }
        } else if (MutableLongCollection.class.isAssignableFrom(type)) {
            if (MutableLongList.class.isAssignableFrom(type)) {
                return LongArrayList.class;
            } else if (MutableLongSet.class.isAssignableFrom(type)) {
                return LongHashSet.class;
            } else if (MutableLongBag.class.isAssignableFrom(type)) {
                return LongHashBag.class;
            }
        } else if (MutableShortCollection.class.isAssignableFrom(type)) {
            if (MutableShortList.class.isAssignableFrom(type)) {
                return ShortArrayList.class;
            } else if (MutableShortSet.class.isAssignableFrom(type)) {
                return ShortHashSet.class;
            } else if (MutableShortBag.class.isAssignableFrom(type)) {
                return ShortHashBag.class;
            }
        }

        return super.resolveInterface(type);
    }

}
