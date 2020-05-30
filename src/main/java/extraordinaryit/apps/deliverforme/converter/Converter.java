package extraordinaryit.apps.deliverforme.converter;

public interface Converter<R, T> {
    T convert(R r);
    R reverseConvert(T t);
}
