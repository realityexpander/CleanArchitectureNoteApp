package com.realityexpander.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;
import java.lang.String;

@OriginatingElement(
    topLevelClass = AddEditNoteViewModel.class
)
public final class AddEditNoteViewModel_HiltModules {
  private AddEditNoteViewModel_HiltModules() {
  }

  @Module
  @InstallIn(ViewModelComponent.class)
  public abstract static class BindsModule {
    private BindsModule() {
    }

    @Binds
    @IntoMap
    @StringKey("com.realityexpander.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel")
    @HiltViewModelMap
    public abstract ViewModel binds(AddEditNoteViewModel vm);
  }

  @Module
  @InstallIn(ActivityRetainedComponent.class)
  public static final class KeyModule {
    private KeyModule() {
    }

    @Provides
    @IntoSet
    @HiltViewModelMap.KeySet
    public static String provide() {
      return "com.realityexpander.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel";
    }
  }
}
