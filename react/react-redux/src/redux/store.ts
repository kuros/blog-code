import {applyMiddleware, compose, createStore} from "redux";
import rootReducer from "./rootReducer";
import immutableStateInvariantMiddleware  from "redux-immutable-state-invariant";


export default function configureStore(initialState?: any) {

    // @ts-ignore
    const composeEnhancers =
        (<any>window).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose; // add support for Redux dev tools

    return createStore(rootReducer,
        initialState,
        composeEnhancers(applyMiddleware(immutableStateInvariantMiddleware())))
}