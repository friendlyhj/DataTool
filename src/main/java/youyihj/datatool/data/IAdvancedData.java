package youyihj.datatool.data;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.data.IData;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.datatool.data.impl.DataConverter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name("mods.datatool.IAdvancedData")
public interface IAdvancedData {
    @ZenCodeType.Field
    IAdvancedData ABSENT = new IAdvancedData() {
        @Override
        public IData asIData() {
            throw new RuntimeException("ABSENT DATA");
        }

        @Override
        public String asString() {
            return "ABSENT DATA";
        }

        @Override
        public IAdvancedData add(IAdvancedData other) {
            return this;
        }

        @Override
        public IAdvancedData sub(IAdvancedData other) {
            return this;
        }

        @Override
        public String toString() {
            return asString();
        }
    };

    @ZenCodeType.Method
    static IAdvancedData of(@ZenCodeType.Nullable IData data) {
        return DataConverter.advance(data);
    }

    IData asIData();

    @ZenCodeType.Method
    default <T extends IData> T cast(Class<T> clazz) {
        IData data = asIData();
        if (clazz.isInstance(data)) {
            return clazz.cast(data);
        } else {
            throw new IllegalArgumentException(data + " is not a " + clazz.getName());
        }
    }

    @ZenCodeType.Getter
    default boolean isAbsent() {
        return this == ABSENT;
    }

    @ZenCodeType.Getter
    default boolean isPresent() {
        return this != ABSENT;
    }

    @ZenCodeType.Method
    default IAdvancedData orElse(IAdvancedData other) {
        return isAbsent() ? other : this;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default int asInt() {
        return 0;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default short asShort() {
        return 0;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default float asFloat() {
        return 0;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default double asDouble() {
        return 0;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default long asLong() {
        return 0;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default byte asByte() {
        return 0;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default boolean asBoolean() {
        return false;
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default byte[] asByteArray() {
        return new byte[0];
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default int[] asIntArray() {
        return new int[0];
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default long[] asLongArray() {
        return new long[0];
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    String asString();

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default List<IAdvancedData> asList() {
        return Collections.emptyList();
    }

    @ZenCodeType.Method
    @ZenCodeType.Caster
    default Map<String, IAdvancedData> asMap() {
        return Collections.emptyMap();
    }

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.INDEXGET)
    default IAdvancedData indexGet(int index) {
        return ABSENT;
    }

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.INDEXSET)
    default void indexSet(int index, IAdvancedData data) {}

    @ZenCodeType.Method
    default void clear() {}

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.ADD)
    IAdvancedData add(IAdvancedData other);

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.SUB)
    default IAdvancedData sub(IAdvancedData other) {
        return IAdvancedData.ABSENT;
    }

    @ZenCodeType.Method
    default void remove(int index) {}

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.MEMBERGETTER)
    default IAdvancedData memberGet(String key) {
        return ABSENT;
    }

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.MEMBERSETTER)
    default void memberSet(String key, IAdvancedData data) {}

    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.CONTAINS)
    default boolean contains(IAdvancedData other) {
        return asIData().contains(other.asIData());
    }

    @ZenCodeType.Getter
    default int size() {
        return 0;
    }
}
