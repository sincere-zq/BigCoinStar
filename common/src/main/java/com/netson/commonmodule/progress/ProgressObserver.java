package com.netson.commonmodule.progress;

import android.content.Context;
import android.util.Log;

import com.netson.commonmodule.utils.LogUtil;
import com.netson.commonmodule.utils.ToastUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * 观察者
 */
public class ProgressObserver<T> implements Observer<T>, ProgressCancelListener {
    private static final String TAG = "ProgressObserver____ ";
    private ObserverResponseListener listener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Context context;
    private Disposable d;

    public ProgressObserver(Context context, ObserverResponseListener listener, boolean isDialog, boolean cancelable) {
        this.listener = listener;
        this.context = context;
        if (isDialog) {
            mProgressDialogHandler = new ProgressDialogHandler(context, this, cancelable);
        }
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        Log.e(TAG, "onSubscribe: ");
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if (t != null) {
            LogUtil.i(t.toString());
            listener.onNext(t);//可定制接口，通过code回调处理不同的业务
        } else {
            listener.onError(new Throwable());
        }
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        Log.e(TAG, "onError: ", e);
        //自定义异常处理
        if (e instanceof UnknownHostException) {
            ToastUtils.toastShortMessage("请打开网络");
        } else if (e instanceof SocketTimeoutException) {
            ToastUtils.toastShortMessage("请求超时");
        } else if (e instanceof ConnectException) {
            ToastUtils.toastShortMessage("连接失败");
        } else if (e instanceof HttpException) {
            ToastUtils.toastShortMessage("请求超时");
        } else {
            ToastUtils.toastShortMessage("请求失败");
        }
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
        Log.e(TAG, "onComplete: ");
    }

    @Override
    public void onCancelProgress() {
        Log.e(TAG, "requestCancel: ");
        //如果处于订阅状态，则取消订阅
        if (!d.isDisposed()) {
            d.dispose();
        }
    }
}
