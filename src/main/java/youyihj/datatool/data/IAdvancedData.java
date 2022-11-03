package youyihj.datatool.data;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.data.IData;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.datatool.data.impl.DataConverter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * An IAdvancedData is a wrapper of IData. It provides an easier way to handle data.
 *
 * @docParam this (1 as IData).advance()
 * @author youyihj
 */
@ZenRegister
@Document("mods/DataTool/IAdvancedData")
@ZenCodeType.Name("mods.datatool.IAdvancedData")
public interface IAdvancedData {
    /**
     * An IAdvancedData with no IData reference. Replaces null value to avoid annoying null check.
     *
     * asNumber/asBoolean/asString methods return 0/false/empty string.
     *
     * indexGet and memberGet method return absent data itself.
     */
    @ZenCodeType.Field
    IAdvancedData ABSENT = new IAdvancedData() {
        @Override
        public IData asIData() {
            throw new RuntimeException("ABSENT DATA");
        }

        @Override
        public String asString() {
            return "";
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

    /**
     * Converts to CraftTweaker IData. Throws an exception if the advanced data is not an instance of the expected class.
     * @param clazz the targeted IData subclass
     * @return the IData
     */
    @ZenCodeType.Method
    default <T extends IData> T cast(Class<T> clazz) {
        IData data = asIData();
        if (clazz.isInstance(data)) {
            return clazz.cast(data);
        } else {
            throw new IllegalArgumentException(data + " is not a " + clazz.getName());
        }
    }

    /**
     * If the data doesn't handle a value
     */
    @ZenCodeType.Getter
    default boolean isAbsent() {
        return this == ABSENT;
    }

    /**
     * If the data handle a value
     */
    @ZenCodeType.Getter
    default boolean isPresent() {
        return this != ABSENT;
    }

    /**
     * Returns the contained instance if it is present; defaultValue otherwise
     */
    @ZenCodeType.Method
    default IAdvancedData orElse(IAdvancedData defaultValue) {
        return isAbsent() ? defaultValue : this;
    }

    /**
     * Gets the value of this data to int. Returns 0 if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default int asInt() {
        return 0;
    }

    /**
     * Gets the value of this data to short. Returns 0 if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default short asShort() {
        return 0;
    }

    /**
     * Gets the value of this data to float. Returns 0 if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default float asFloat() {
        return 0;
    }

    /**
     * Gets the value of this data to double. Returns 0 if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default double asDouble() {
        return 0;
    }

    /**
     * Gets the value of this data to long. Returns 0 if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default long asLong() {
        return 0;
    }

    /**
     * Gets the value of this data to byte. Returns 0 if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default byte asByte() {
        return 0;
    }

    /**
     * Gets the value of this data to boolean. Returns false if it is not a number.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default boolean asBoolean() {
        return false;
    }

    /**
     * Gets the value of this data to byte array. Returns an empty array if it is not an array.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default byte[] asByteArray() {
        return new byte[0];
    }

    /**
     * Gets the value of this data to int array. Returns an empty array if it is not an array.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default int[] asIntArray() {
        return new int[0];
    }

    /**
     * Gets the value of this data to long array. Returns an empty array if it is not an array.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default long[] asLongArray() {
        return new long[0];
    }

    /**
     * Gets a string representation of this data
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    String asString();

    /**
     * Gets a List representation of this IData. Returns an empty list if it is not a list or an array.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default List<IAdvancedData> asList() {
        return Collections.emptyList();
    }

    /**
     * Gets a Map representation of this IData. Returns an empty map if it is not a DataMap.
     */
    @ZenCodeType.Method
    @ZenCodeType.Caster
    default Map<String, IAdvancedData> asMap() {
        return Collections.emptyMap();
    }

    /**
     * Gets the data on the given index. Returns absent data if it is not a list or an array.
     */
    @ZenCodeType.Method
    default IAdvancedData indexGet(int index) {
        return ABSENT;
    }

    /**
     * Sets the data on the given index. Returns absent data if it is not a list or an array.
     */
    @ZenCodeType.Method
    default void indexSet(int index, IAdvancedData data) {}

    /**
     * Removes all elements of this data. Only works for DataList.
     */
    @ZenCodeType.Method
    default void clear() {}

    /**
     * Returns a new data as the combination of the two data. The operation doesn't mutate the origin data.
     */
    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.ADD)
    IAdvancedData add(IAdvancedData other);

    /**
     * Returns a new data as the subtraction of the two data. Returns absent data if the operation is not supported.
     * The operation doesn't mutate the origin data.
     */
    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.SUB)
    default IAdvancedData sub(IAdvancedData other) {
        return IAdvancedData.ABSENT;
    }

    /**
     * Removes the element of this data at the given index. Only works for DataList.
     */
    @ZenCodeType.Method
    default void remove(int index) {}

    /**
     * Gets the value associated with the key. Only works for DataMap
     */
    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.MEMBERGETTER)
    default IAdvancedData memberGet(String key) {
        return ABSENT;
    }

    /**
     * Sets the value associated with the key. Only works for DataMap
     */
    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.MEMBERSETTER)
    default void memberSet(String key, IAdvancedData data) {}

    /**
     * Checks if this IData contains another IData
     */
    @ZenCodeType.Method
    @ZenCodeType.Operator(ZenCodeType.OperatorType.CONTAINS)
    default boolean contains(IAdvancedData other) {
        return asIData().contains(other.asIData());
    }

    /**
     * Gets the size of this data.
     */
    @ZenCodeType.Getter
    default int size() {
        return 0;
    }
}
