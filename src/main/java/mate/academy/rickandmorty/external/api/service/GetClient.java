package mate.academy.rickandmorty.external.api.service;

public interface GetClient<T> {
    T getDtoFromApi(String url);
}
