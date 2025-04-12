import {Box, Card, Group, RingProgress, Text} from "@mantine/core";

type ResourceCardProps = {
  title: string;
  usage: number;
  color?: string
}

const ResourceCard = ({title, usage, color}: ResourceCardProps) => {
  return (
    <Card shadow="lg" padding="md" radius="md" withBorder>
      <Text size="lg" mb="xs">{title}</Text>
      <Group mb="sm">
        <Box
          style={{
            width: 100,
            height: 100,
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            backgroundColor: color || 'rgb(220, 240, 220)',  // 背景颜色
            borderRadius: '50%',
            position: 'relative',
          }}
        >
          <RingProgress
            sections={[{value: usage, color: 'blue'}]}
            label={
              <Text c="blue" fw={700} ta="center" size="xl">
                40%
              </Text>
            }
          />
        </Box>
      </Group>
      <Text size="sm">
        正常范围
      </Text>
    </Card>
  );
};

export {ResourceCard}