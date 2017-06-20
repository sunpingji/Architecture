package pjsun.architecture;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import java.util.List;

/**
 * Created by sunpingji on 2017/6/20.
 */

public class ProductViewModel extends AndroidViewModel {

    private LiveData<List<Product>> productLiveData;

    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private MutableLiveData<Boolean> isLoaded = new MutableLiveData<>();

    public ProductViewModel(Application application) {
        super(application);
        productLiveData = Transformations.switchMap(isLoaded, new Function<Boolean, LiveData<List<Product>>>() {
            @Override
            public LiveData<List<Product>> apply(Boolean input) {
                return null;
            }
        });
    }

    public LiveData<List<Product>> getProductLiveData() {
        return productLiveData;
    }
}
