// import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
// import axios from 'axios';
//
// export interface apiSliceSate {
//     jwt: string;
//     isLogged: boolean;
// }
//
// const initialState: apiSliceSate = {
//     jwt: '',
//     isLogged: false,
// };
//
// const apiBaseUrl: string = 'http://10.0.2.2:3605/api/users/';
//
// export const tryLogIn = createAsyncThunk(
//     'user/tryLogIn',
//     async (credentials: { email: string, password: string }) => {
//         try {
//             const response = await axios.post(apiBaseUrl + 'login', credentials, {
//                 headers: {
//                     'Content-Type': 'application/json',
//                 },
//             });
//             console.log(response.data);
//             return response.data;
//         } catch (error) {
//             console.error(error);
//         }
//     },
// );
//
// export const trySignUp = createAsyncThunk(
//     'user/tryLogIn',
//     async (credentials: { email: string, password: string }) => {
//         try {
//             const response = await axios.post(apiBaseUrl + 'add', credentials, {
//                 headers: {
//                     'Content-Type': 'application/json',
//                 },
//             });
//             console.log(response.data);
//             return response.data;
//         } catch (error) {
//             console.error(error);
//         }
//     },
// );
//
// const apiSlice = createSlice({
//     name: 'apiSlice',
//     initialState,
//     reducers: {},
//     extraReducers: (builder) => {
//         builder.addCase(tryLogIn.pending, (state) => {
//             state.isLogged = false;
//             state.jwt = '';
//         });
//         builder.addCase(tryLogIn.rejected, (state, action) => {
//             console.error('Failed to try to login: ', action.error);
//             state.isLogged = false;
//             state.jwt = '';
//         });
//         builder.addCase(tryLogIn.fulfilled, (state, action) => {
//             state.jwt = action.payload;
//             state.isLogged = true;
//         });
//     },
// });
//
// export default apiSlice.reducer;
