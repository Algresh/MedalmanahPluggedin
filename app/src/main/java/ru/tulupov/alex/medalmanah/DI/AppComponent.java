package ru.tulupov.alex.medalmanah.DI;

import dagger.Component;
import ru.tulupov.alex.medalmanah.NewsFragment;

@Component(modules = {NewsModule.class})
public interface AppComponent {
    void inject(NewsFragment fragment);
}
