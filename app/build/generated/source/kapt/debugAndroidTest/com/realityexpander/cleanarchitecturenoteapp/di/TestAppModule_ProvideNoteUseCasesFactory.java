// Generated by Dagger (https://dagger.dev).
package com.realityexpander.cleanarchitecturenoteapp.di;

import com.realityexpander.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository;
import com.realityexpander.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TestAppModule_ProvideNoteUseCasesFactory implements Factory<NoteUseCases> {
  private final Provider<NoteRepository> repositoryProvider;

  public TestAppModule_ProvideNoteUseCasesFactory(Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public NoteUseCases get() {
    return provideNoteUseCases(repositoryProvider.get());
  }

  public static TestAppModule_ProvideNoteUseCasesFactory create(
      Provider<NoteRepository> repositoryProvider) {
    return new TestAppModule_ProvideNoteUseCasesFactory(repositoryProvider);
  }

  public static NoteUseCases provideNoteUseCases(NoteRepository repository) {
    return Preconditions.checkNotNullFromProvides(TestAppModule.INSTANCE.provideNoteUseCases(repository));
  }
}