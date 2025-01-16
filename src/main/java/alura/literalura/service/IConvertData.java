package alura.literalura.service;

public interface IConvertData {
    <T> T IgetData(String json, Class<T> clazz);
}
