package com.example.toor.movieviewer.model.repo;

import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.functions.Function;
import timber.log.Timber;

public abstract class NetworkBoundSource<LocalType, RemoteType> {

    public NetworkBoundSource(FlowableEmitter<LocalType> emitter) {
        Timber.d("aaaaaa2");
        Flowable.concat(getLocal(), getRemote());
//                .subscribe(localTypeData -> {
//                    firstDataDisposable.dispose();
//                    saveCallResult(localTypeData);
//                    getLocal()
//                            .subscribe(emitter::onNext);
//                });
    }

    public abstract Flowable<RemoteType> getRemote();

    public abstract Flowable<LocalType> getLocal();

    public abstract void saveCallResult(LocalType data);

    public abstract Function<RemoteType, LocalType> mapper();

}
