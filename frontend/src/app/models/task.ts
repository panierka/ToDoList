export class Task
{
    id: number | undefined;
    content: string = "New Task";
    isCompleted: boolean = false;
    description: string = "abc";
    deadline: Date | undefined;
    order: number = 0;
}