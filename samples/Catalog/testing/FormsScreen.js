import React, { Component } from "react";

import {
    View,
    Button,
    NativeModules
} from "react-native"

import PSPDFKitView from "react-native-pspdfkit";

export default class FormsScreen extends Component<{}> {
    static navigationOptions = ({ navigation }) => {
        return {
            title: "PDF"
        };
    };

    componentDidMount() {
        NativeModules.TestingModule.setValue("did_load", "true");
    }

    render() {
        return (
            <View style={{ flex: 1 }}>
                <PSPDFKitView
                    ref="pdfView"
                    document="file:///android_asset/Form_example.pdf"
                    configuration={{
                    }}
                    fragmentTag="PDF1"
                    annotationAuthorName="Author"
                    style={{ flex: 1 }}
                />
                <View style={{ flexDirection: 'row', height: 40, alignItems: 'center', padding: 10 }}>
                    <Button onPress={() => {
                        this.refs.pdfView.getFormFieldValue("Name_Last").then(value => {
                            NativeModules.TestingModule.setValue("lastName", JSON.stringify(value));
                        })
                        this.refs.pdfView.getFormFieldValue("Name_First").then(value => {
                            NativeModules.TestingModule.setValue("firstName", JSON.stringify(value));
                        })
                    }} title="Get" />
                    <Button onPress={() => {
                        this.refs.pdfView.setFormFieldValue("Name_Last", "Appleseed");
                        this.refs.pdfView.setFormFieldValue("Name_First", "John");
                    }} title="Set" />
                </View>
            </View>
        );
    }
}