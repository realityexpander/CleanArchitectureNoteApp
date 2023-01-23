// Generated by Dagger (https://dagger.dev).
package com.realityexpander.cleanarchitecturenoteapp.di;

import com.realityexpander.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase;
import com.realityexpander.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TestAppModule_ProvideNoteRepositoryFactory implements Factory<NoteRepository> {
  private final Provider<NoteDatabase> dbProvider;

  public TestAppModule_ProvideNoteRepositoryFactory(Provider<NoteDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public NoteRepository get() {
    return provideNoteRepository(dbProvider.get());
  }

  public static TestAppModule_ProvideNoteRepositoryFactory create(
      Provider<NoteDatabase> dbProvider) {
    return new TestAppModule_ProvideNoteRepositoryFactory(dbProvider);
  }

  public static NoteRepository provideNoteRepository(NoteDatabase db) {
    return Preconditions.checkNotNullFromProvides(TestAppModule.INSTANCE.provideNoteRepository(db));
  }
}
