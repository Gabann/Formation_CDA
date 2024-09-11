import {configureStore} from '@reduxjs/toolkit';
import productApiSlice from '@/src/store/productApiSlice';

export const store = configureStore({
    reducer: {
        productApiSlice: productApiSlice,
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({
            serializableCheck: false,
        }),
});

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
