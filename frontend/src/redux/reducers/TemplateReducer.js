import {
    CREATE_TEMPLATE_EVENTS_ACTION,
    DELETE_TEMPLATE_AND_TEMPLATE_EVENTS_ACTION,
    DELETE_TEMPLATE_EVENTS_ACTION,
    GET_TEMPLATE_ACTION,
    POST_TEMPLATE_ACTION,
    PUT_TEMPLATE_AND_TEMPLATE_EVENTS_ACTION
} from "../actions/ActionTypes";

const initialState = {
    templates:[]
};

export function templateReducer(state = initialState, action) {
    switch (action.type) {
        case GET_TEMPLATE_ACTION:
            return state.templates.filter(template => template.id !== action.payload.id).push(action.payload);
        case POST_TEMPLATE_ACTION:
            return {...state, templates: [...state.templates, action.payload]};
        case CREATE_TEMPLATE_EVENTS_ACTION:
            return state.templates.filter(template => template.id !== action.payload.id).push(action.payload);
        case PUT_TEMPLATE_AND_TEMPLATE_EVENTS_ACTION:
            return state.templates.filter(template => template.id !== action.payload.id).push(action.payload);
        case DELETE_TEMPLATE_AND_TEMPLATE_EVENTS_ACTION:
            return state.templates.filter(template => template.id !== action.payload);
        case DELETE_TEMPLATE_EVENTS_ACTION:
            return state.templates.filter(template => template.id !== action.payload);
        default:
            return state;
    }
}