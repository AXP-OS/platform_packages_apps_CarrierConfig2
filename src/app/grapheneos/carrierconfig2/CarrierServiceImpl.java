package app.grapheneos.carrierconfig2;

import android.annotation.Nullable;
import android.os.PersistableBundle;
import android.service.carrier.CarrierIdentifier;
import android.service.carrier.CarrierService;
import android.util.Log;

import app.grapheneos.carrierconfig2.loader.CSettingsDir;
import app.grapheneos.carrierconfig2.loader.CarrierConfigLoader;

public class CarrierServiceImpl extends CarrierService {
    static final String TAG = CarrierServiceImpl.class.getSimpleName();

    @Nullable
    @Override
    public PersistableBundle onLoadConfig(@Nullable CarrierIdentifier carrierId) {
        Log.d(TAG, "carrierId " + carrierId);

        CSettingsDir csd = CSettingsDir.getDefault();
        if (csd == null) {
            Log.e(TAG, "missing CSettingsDir");
            return null;
        }

        return new CarrierConfigLoader(getApplicationContext(), csd).load(carrierId);
    }
}
