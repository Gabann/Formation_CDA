import React from "react";
import {ComponentPreview, Previews} from "@react-buddy/ide-toolbox";
import {PaletteTree} from "./palette";
import {TestComponent} from "../components/TestComponent.tsx";
import {PersonDirectory} from "../components/PersonDirectory.tsx";

const ComponentPreviews = () => {
    return (
        <Previews palette={<PaletteTree/>}>
            <ComponentPreview path="/TestComponent">
                <TestComponent/>
            </ComponentPreview>
            <ComponentPreview path="/PersonDirectory">
                <PersonDirectory/>
            </ComponentPreview>
        </Previews>
    );
};

export default ComponentPreviews;